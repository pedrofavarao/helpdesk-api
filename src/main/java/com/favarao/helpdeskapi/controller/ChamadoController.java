package com.favarao.helpdeskapi.controller;

import com.favarao.helpdeskapi.constant.StatusChamadoConstant;
import com.favarao.helpdeskapi.constant.UsuarioPermissao;
import com.favarao.helpdeskapi.dto.ChamadoDto;
import com.favarao.helpdeskapi.dto.UserDto;
import com.favarao.helpdeskapi.entity.Chamado;
import com.favarao.helpdeskapi.entity.Prioridade;
import com.favarao.helpdeskapi.entity.TipoChamado;
import com.favarao.helpdeskapi.entity.User;
import com.favarao.helpdeskapi.repository.*;
import com.favarao.helpdeskapi.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChamadoService chamadoService;
    @Autowired
    private ChamadoRepository chamadoRepository;
    @Autowired
    private TipoChamadoRerpository tipoChamadoRerpository;
    @Autowired
    private PrioridadeRepository prioridadeRepository;
    @Autowired
    private StatusChamadoRepository statusChamadoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Chamado criarChamado(@RequestBody ChamadoDto chamado){
        Chamado newChamado = new Chamado();
        TipoChamado tipoChamado = tipoChamadoRerpository.findById(chamado.tipoChamadoId()).orElseThrow(() -> new RuntimeException("Tipo Chamado não encontrado!"));
        User solicitante = userRepository.findById(chamado.solicitanteId()).orElseThrow(() -> new RuntimeException("Solicitante não encontrado!"));
        Prioridade prioridade = prioridadeRepository.findById(chamado.prioridadeId()).orElseThrow(() -> new RuntimeException("Tipo Chamado não encontrado!"));

        newChamado.setTipoChamado(tipoChamado);
        newChamado.setDescricao(chamado.descricao());
        newChamado.setSolicitante(solicitante);
        newChamado.setStatus(StatusChamadoConstant.ABERTO);
        newChamado.setPrioridade(prioridade);

        return chamadoRepository.save(newChamado);
    }

    @PostMapping("/{chamadoId}")
    public ResponseEntity<Chamado> iniciarChamado(@PathVariable Long chamadoId, @RequestBody UserDto responsavelId){
        Chamado chamado = chamadoRepository.findById(chamadoId).orElseThrow(() -> new RuntimeException("Chamado não encontrado!"));
        User responsavel = userRepository.findById(responsavelId.id()).orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        if(responsavel.getRole().equals(UsuarioPermissao.ADMIN)){
            chamado.setResponsavel(responsavel);
            chamado.setStatus(StatusChamadoConstant.EM_ANDAMENTO);
            chamadoRepository.save(chamado);
            return ResponseEntity.ok(chamado);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping("/finalizar/{chamadoId}")
    public ResponseEntity<Chamado> finalizarChamado(@PathVariable Long chamadoId){
        Chamado chamadoFinalizar = chamadoRepository.findById(chamadoId).get();
        chamadoFinalizar.setStatus(StatusChamadoConstant.FINALIZADO);

        return ResponseEntity.ok(chamadoRepository.save(chamadoFinalizar));
    }

    @GetMapping
    private List<Chamado> listar(){
        return chamadoRepository.findAll();
    }

    @GetMapping("/abertoAndamento")
    private List<Chamado> listarAbertoAndamento(){
        return chamadoService.listarAbertosAndamento(chamadoRepository.findAll());
    }

    @GetMapping("/responsavel/{responsavelId}")
    public List<Chamado> listarChamadoPorResponsavel(@PathVariable Long responsavelId){
        return chamadoRepository.findByResponsavel(userRepository.findById(responsavelId).orElseThrow(() -> new RuntimeException("User not found!")));
    }

    @GetMapping("/solicitante/{solicitanteId}")
    public List<Chamado> listarChamadoPorSolicitante(@PathVariable Long solicitanteId){
        return chamadoRepository.findBySolicitante(userRepository.findById(solicitanteId).orElseThrow(() -> new RuntimeException("User not found!")));
    }

    @GetMapping("/{chamadoId}")
    public ResponseEntity<Chamado> buscarPorId(@PathVariable Long chamadoId){
        return chamadoRepository.findById(chamadoId)
                .map(chamado -> ResponseEntity.ok(chamado))
                .orElse(ResponseEntity.notFound().build());
    }
}

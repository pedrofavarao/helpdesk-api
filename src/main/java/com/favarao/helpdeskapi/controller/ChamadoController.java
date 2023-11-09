package com.favarao.helpdeskapi.controller;

import com.favarao.helpdeskapi.constant.StatusChamadoConstant;
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

    @GetMapping
    private List<Chamado> listar(){
        return chamadoRepository.findAll();
    }

    @PostMapping("/{chamadoId}")
    public ResponseEntity<Chamado> iniciarChamado(@PathVariable Long chamadoId, @RequestBody UserDto responsavelId){
        Chamado chamado = chamadoRepository.findById(chamadoId).orElseThrow(() -> new RuntimeException("Chamado não encontrado!"));
        User responsavel = userRepository.findById(responsavelId.id()).orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        if(responsavel.getRole().equals("ADMIN")){
            chamado.setResponsavel(responsavel);
            chamado.setStatus(StatusChamadoConstant.EM_ANDAMENTO);
            chamadoRepository.save(chamado);
            return ResponseEntity.ok(chamado);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}

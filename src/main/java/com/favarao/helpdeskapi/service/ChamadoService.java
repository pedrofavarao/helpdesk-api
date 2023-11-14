package com.favarao.helpdeskapi.service;

import com.favarao.helpdeskapi.constant.StatusChamadoConstant;
import com.favarao.helpdeskapi.entity.Chamado;
import com.favarao.helpdeskapi.repository.ChamadoRepository;
import com.favarao.helpdeskapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChamadoService {
    @Autowired
    private ChamadoRepository chamadoRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Chamado> listarAbertosAndamento(List<Chamado> chamados){
        List<Chamado> chamadosAtualizado = new ArrayList<>();
        for (Chamado chamado : chamados) {
            if(!chamado.getStatus().equals(StatusChamadoConstant.FINALIZADO)){
                chamadosAtualizado.add(chamado);
            }
        }
        return chamadosAtualizado;
    }
}

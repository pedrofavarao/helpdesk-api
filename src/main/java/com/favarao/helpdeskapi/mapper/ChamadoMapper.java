package com.favarao.helpdeskapi.mapper;

import com.favarao.helpdeskapi.dto.ChamadoDto;
import com.favarao.helpdeskapi.entity.Chamado;

public class ChamadoMapper {
    public static ChamadoDto entityToDto(Chamado chamado){
        // TODO Fazer conversao de entity to dto
        return null;
    }

    public static Chamado dtoToEntity(ChamadoDto chamadoDto){
        Chamado chamado = new Chamado();
        chamado.getTipoChamado().setId(chamadoDto.tipoChamadoId());
        chamado.setDescricao(chamadoDto.descricao());
        chamado.getSolicitante().setId(chamadoDto.solicitanteId());
        chamado.getResponsavel().setId(chamadoDto.responsavelId());
        chamado.setStatus(chamadoDto.status());
        chamado.getPrioridade().setId(chamadoDto.prioridadeId());
        return chamado;
    }
}

package com.favarao.helpdeskapi.dto;

public record ChamadoDto(

        Long Id,
        Long tipoChamadoId,
        String descricao,
        Long solicitanteId,
        Long responsavelId,
        String status,
        Long prioridadeId
) {
}

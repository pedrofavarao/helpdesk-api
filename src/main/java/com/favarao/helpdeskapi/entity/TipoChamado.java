package com.favarao.helpdeskapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tipo_Chamado")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TipoChamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "descricao_chamado")
    @NotBlank
    private String descricaoChamado;

    @Column(name = "tipo_chamado")
    @NotBlank
    String tipoChamado;
}

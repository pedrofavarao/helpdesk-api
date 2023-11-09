package com.favarao.helpdeskapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="chamado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "tipo_chamado_id")
    @ManyToOne
    private TipoChamado tipoChamado;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "solicitante_id")
    private User solicitante;

    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private User responsavel;

    @Column(name = "status")
    private String status;

    @JoinColumn(name = "prioridade_id")
    @ManyToOne
    private Prioridade prioridade;
}

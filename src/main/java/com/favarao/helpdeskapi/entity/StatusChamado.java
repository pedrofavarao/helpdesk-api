package com.favarao.helpdeskapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "status_chamado")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusChamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "status_chamado")
    @Size(max = 10)
    String statusChamado;
}

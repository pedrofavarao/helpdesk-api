package com.favarao.helpdeskapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prioridade")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prioridade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "prioridade")
    @Size(max = 10)
    @NotBlank
    String prioridade;
}

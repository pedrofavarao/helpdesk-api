package com.favarao.helpdeskapi.repository;

import com.favarao.helpdeskapi.entity.Prioridade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrioridadeRepository extends JpaRepository<Prioridade, Long> {
    Optional<Prioridade> findByPrioridade(String prioridade);
}

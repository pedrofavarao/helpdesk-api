package com.favarao.helpdeskapi.repository;

import com.favarao.helpdeskapi.entity.StatusChamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusChamadoRepository extends JpaRepository<StatusChamado, Long> {
    Optional<StatusChamado> findByStatusChamadoContaining(String statusChamado);
}

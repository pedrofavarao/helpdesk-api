package com.favarao.helpdeskapi.repository;

import com.favarao.helpdeskapi.entity.TipoChamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoChamadoRerpository extends JpaRepository<TipoChamado, Long> {
    Optional<TipoChamado> findByTipoChamado(String tipoChamado);
}

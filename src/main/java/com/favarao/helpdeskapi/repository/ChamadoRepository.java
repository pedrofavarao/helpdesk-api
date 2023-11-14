package com.favarao.helpdeskapi.repository;

import com.favarao.helpdeskapi.entity.Chamado;
import com.favarao.helpdeskapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Long> {
    List<Chamado> findByResponsavel(User responsavel);
    List<Chamado> findBySolicitante(User responsavel);
}

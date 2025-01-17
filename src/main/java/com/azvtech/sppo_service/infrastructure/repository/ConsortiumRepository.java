package com.azvtech.sppo_service.infrastructure.repository;

import com.azvtech.sppo_service.domain.model.Consortium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Fellipe Toledo
 */


public interface ConsortiumRepository extends JpaRepository<Consortium, Long> {
    Optional<Consortium> findByCnpj(String cnpj);
    boolean existsByCnpj(String cnpj);
}

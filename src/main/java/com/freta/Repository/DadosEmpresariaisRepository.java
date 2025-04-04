package com.freta.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freta.Entity.DadosEmpresariaisEntity;

@Repository
public interface DadosEmpresariaisRepository extends JpaRepository<DadosEmpresariaisEntity, Long>{
    boolean existsByCnpj(String cnpj);
    boolean existsByInscricaoEstadual(String inscricaoEstadual);
    Optional<DadosEmpresariaisEntity> findByClienteId(Long id);
}

package br.com.cadastro.basico.beneficio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastro.basico.beneficio.model.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
    List<Documento> findByBeneficiarioId(Long beneficiarioId);
}

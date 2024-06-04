package br.com.cadastro.basico.beneficio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastro.basico.beneficio.model.Beneficiario;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
}

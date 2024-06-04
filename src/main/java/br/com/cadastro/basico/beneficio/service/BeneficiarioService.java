package br.com.cadastro.basico.beneficio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.basico.beneficio.model.Beneficiario;
import br.com.cadastro.basico.beneficio.repository.BeneficiarioRepository;

@Service
public class BeneficiarioService {
    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    public Beneficiario save(Beneficiario beneficiario) {
        return beneficiarioRepository.save(beneficiario);
    }

    public List<Beneficiario> findAll() {
        return beneficiarioRepository.findAll();
    }

    public Beneficiario findById(Long id) {
        return beneficiarioRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        beneficiarioRepository.deleteById(id);
    }
}

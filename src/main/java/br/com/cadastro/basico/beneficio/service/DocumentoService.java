package br.com.cadastro.basico.beneficio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.basico.beneficio.model.Documento;
import br.com.cadastro.basico.beneficio.repository.DocumentoRepository;

@Service
public class DocumentoService {
    @Autowired
    private DocumentoRepository documentoRepository;

    public List<Documento> findByBeneficiarioId(Long beneficiarioId) {
        return documentoRepository.findByBeneficiarioId(beneficiarioId);
    }
}

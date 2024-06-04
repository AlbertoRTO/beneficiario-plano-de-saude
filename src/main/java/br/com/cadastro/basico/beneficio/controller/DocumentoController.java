package br.com.cadastro.basico.beneficio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.basico.beneficio.model.Documento;
import br.com.cadastro.basico.beneficio.service.DocumentoService;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoController {
    @Autowired
    private DocumentoService documentoService;

    @GetMapping("/beneficiario/{beneficiarioId}")
    public ResponseEntity<List<Documento>> getDocumentosByBeneficiarioId(@PathVariable Long beneficiarioId) {
        List<Documento> documentos = documentoService.findByBeneficiarioId(beneficiarioId);
        return ResponseEntity.ok(documentos);
    }
}
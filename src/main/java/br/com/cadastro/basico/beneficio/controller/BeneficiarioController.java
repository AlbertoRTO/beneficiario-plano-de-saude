package br.com.cadastro.basico.beneficio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.basico.beneficio.model.Beneficiario;
import br.com.cadastro.basico.beneficio.service.BeneficiarioService;

@RestController
@RequestMapping("/api/beneficiarios")
public class BeneficiarioController {
    @Autowired
    private BeneficiarioService beneficiarioService;

    @PostMapping
    public ResponseEntity<Beneficiario> createBeneficiario(@RequestBody Beneficiario beneficiario) {
        Beneficiario savedBeneficiario = beneficiarioService.save(beneficiario);
        return ResponseEntity.ok(savedBeneficiario);
    }

    @GetMapping
    public ResponseEntity<List<Beneficiario>> getAllBeneficiarios() {
        List<Beneficiario> beneficiarios = beneficiarioService.findAll();
        return ResponseEntity.ok(beneficiarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Beneficiario> getBeneficiarioById(@PathVariable Long id) {
        Beneficiario beneficiario = beneficiarioService.findById(id);
        if (beneficiario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(beneficiario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Beneficiario> updateBeneficiario(@PathVariable Long id, @RequestBody Beneficiario beneficiarioDetails) {
        Beneficiario beneficiario = beneficiarioService.findById(id);
        if (beneficiario == null) {
            return ResponseEntity.notFound().build();
        }
        beneficiario.setNome(beneficiarioDetails.getNome());
        beneficiario.setTelefone(beneficiarioDetails.getTelefone());
        beneficiario.setDataNascimento(beneficiarioDetails.getDataNascimento());
        beneficiario.setDataAtualizacao(beneficiarioDetails.getDataAtualizacao());

        Beneficiario updatedBeneficiario = beneficiarioService.save(beneficiario);
        return ResponseEntity.ok(updatedBeneficiario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBeneficiario(@PathVariable Long id) {
        Beneficiario beneficiario = beneficiarioService.findById(id);
        if (beneficiario == null) {
            return ResponseEntity.notFound().build();
        }
        beneficiarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
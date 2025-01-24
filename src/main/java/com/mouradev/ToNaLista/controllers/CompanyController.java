package com.mouradev.ToNaLista.controllers;

import com.mouradev.ToNaLista.models.Company;
import com.mouradev.ToNaLista.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@CrossOrigin(origins = "*")
public class CompanyController {
    
    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        return ResponseEntity.ok(companyService.addCompany(company));
    }

    @GetMapping
    public ResponseEntity<List<Company>> findAll() {
        return ResponseEntity.ok(companyService.findAll());
    }
    
    @GetMapping("/{cnpj}")
    public ResponseEntity<Company> findByCnpj(@PathVariable String cnpj) {
        return ResponseEntity.ok(companyService.findByCnpj(cnpj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> editCompany(@PathVariable Long id, @RequestBody Company company) {
        return ResponseEntity.ok(companyService.editCompany(id, company));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        companyService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

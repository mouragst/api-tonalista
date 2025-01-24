package com.mouradev.ToNaLista.controllers;

import com.mouradev.ToNaLista.models.Supplier;
import com.mouradev.ToNaLista.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
@CrossOrigin(origins = "*")
public class SupplierController {
    
    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.ok(supplierService.addSupplier(supplier));
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<List<Supplier>> findAll(@PathVariable Integer companyId) {
        return ResponseEntity.ok(supplierService.findAllByCompanyId(companyId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> findById(@PathVariable Long id) {
        return ResponseEntity.ok(supplierService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> editSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
        return ResponseEntity.ok(supplierService.editSupplier(id, supplier));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        supplierService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

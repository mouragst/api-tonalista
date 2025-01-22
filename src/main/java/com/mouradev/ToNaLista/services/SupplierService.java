package com.mouradev.ToNaLista.services;

import org.springframework.stereotype.Service;
import com.mouradev.ToNaLista.models.Supplier;
import com.mouradev.ToNaLista.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SupplierService {
    
    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier registerSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier findById(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        supplierRepository.deleteById(id);
    }
}

package com.mouradev.ToNaLista.services;

import org.springframework.stereotype.Service;
import com.mouradev.ToNaLista.models.Supplier;
import com.mouradev.ToNaLista.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SupplierService {
    
    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public List<Supplier> findAllByCompanyId(Integer companyId) {
        return supplierRepository.findAllByCompanyId(companyId);
    }

    public Supplier findById(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }

    public Supplier editSupplier(Long id, Supplier supplier) {
        Supplier supplierToEdit = supplierRepository.findById(id).orElse(null);
        if (supplierToEdit != null) {
            supplierToEdit.setCnpj(supplier.getCnpj());
            supplierToEdit.setRazaoSocial(supplier.getRazaoSocial());
            supplierToEdit.setInscricaoMunicipal(supplier.getInscricaoMunicipal());
            supplierToEdit.setInscricaoEstadual(supplier.getInscricaoEstadual());
            supplierToEdit.setCep(supplier.getCep());
            supplierToEdit.setStreet(supplier.getStreet());
            supplierToEdit.setNumber(supplier.getNumber());
            supplierToEdit.setComplement(supplier.getComplement());
            supplierToEdit.setDistrict(supplier.getDistrict());
            supplierToEdit.setCity(supplier.getCity());
            supplierToEdit.setUf(supplier.getUf());
            supplierToEdit.setPhoneNumber(supplier.getPhoneNumber());
            supplierToEdit.setEmail(supplier.getEmail());
            supplierToEdit.setStatus(supplier.getStatus());
            return supplierRepository.save(supplierToEdit);
        }
        return null;
    }

    public void deleteById(Long id) {
        supplierRepository.deleteById(id);
    }
}

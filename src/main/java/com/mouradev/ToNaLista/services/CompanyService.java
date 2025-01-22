package com.mouradev.ToNaLista.services;

import org.springframework.stereotype.Service;
import com.mouradev.ToNaLista.models.Company;
import com.mouradev.ToNaLista.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company registerCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company findByCnpj(String cnpj) {
        return companyRepository.findByCnpj(cnpj).orElse(null);
    }

    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }
    
}

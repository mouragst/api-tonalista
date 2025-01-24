package com.mouradev.ToNaLista.services;

import org.springframework.stereotype.Service;
import com.mouradev.ToNaLista.models.Company;
import com.mouradev.ToNaLista.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company findByCnpj(String cnpj) {
        return companyRepository.findByCnpj(cnpj).orElse(null);
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }
    
    public Company editCompany(Long id, Company company) {
        Company oldCompany = companyRepository.findById(id).orElse(null);
        if (oldCompany != null) {
            oldCompany.setCnpj(company.getCnpj());
            oldCompany.setRazaoSocial(company.getRazaoSocial());
            oldCompany.setInscricaoMunicipal(company.getInscricaoMunicipal());
            oldCompany.setInscricaoEstadual(company.getInscricaoEstadual());
            oldCompany.setPlan(company.getPlan());
            oldCompany.setPlanValue(company.getPlanValue());
            oldCompany.setPlanExpiration(company.getPlanExpiration());
            oldCompany.setPlanLastPayment(company.getPlanLastPayment());
            oldCompany.setPlanDiscount(company.getPlanDiscount());
            oldCompany.setUserLimit(company.getUserLimit());
            oldCompany.setCep(company.getCep());
            oldCompany.setStreet(company.getStreet());
            oldCompany.setNumber(company.getNumber());
            oldCompany.setComplement(company.getComplement());
            oldCompany.setDistrict(company.getDistrict());
            oldCompany.setCity(company.getCity());
            oldCompany.setState(company.getState());
            oldCompany.setCountry(company.getCountry());
            oldCompany.setPhoneNumber(company.getPhoneNumber());
            oldCompany.setEmail(company.getEmail());
            oldCompany.setStatus(company.getStatus());
            oldCompany.setUpdatedAt(company.getUpdatedAt());
            return companyRepository.save(oldCompany);
        } else {
            return null;
        }
    }

    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }
    
}

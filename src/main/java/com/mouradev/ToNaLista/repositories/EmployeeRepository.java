package com.mouradev.ToNaLista.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mouradev.ToNaLista.models.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    Employee findByCpfAndCompanyId(String cpf, Integer companyId);
    List<Employee> findAllByCompanyId(Integer companyId);
    
}

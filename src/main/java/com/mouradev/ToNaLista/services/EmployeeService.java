package com.mouradev.ToNaLista.services;

import org.springframework.stereotype.Service;
import com.mouradev.ToNaLista.models.Employee;
import com.mouradev.ToNaLista.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findByCpf(String cpf, Integer companyId) {
        return employeeRepository.findByCpfAndCompanyId(cpf, companyId);
    }

    public List<Employee> findAllByCompanyId(Integer companyId) {
        return employeeRepository.findAllByCompanyId(companyId);
    }
    
    public Employee editEmployee(Long id, Employee employee) {
        Employee oldEmployee = employeeRepository.findById(id).orElse(null);
        if (oldEmployee != null) {
            oldEmployee.setName(employee.getName());
            oldEmployee.setEmployeeType(employee.getEmployeeType());
            oldEmployee.setCpf(employee.getCpf());
            oldEmployee.setCnpj(employee.getCnpj());
            oldEmployee.setRazaoSocial(employee.getRazaoSocial());
            oldEmployee.setAssignment(employee.getAssignment());
            oldEmployee.setSchedules(employee.getSchedules());
            oldEmployee.setTurn(employee.getTurn());
            oldEmployee.setSalary(employee.getSalary());
            oldEmployee.setSalaryHour(employee.getSalaryHour());
            oldEmployee.setEmail(employee.getEmail());
            oldEmployee.setPhoneNumber(employee.getPhoneNumber());
            oldEmployee.setStatus(employee.getStatus());
            return employeeRepository.save(oldEmployee);
        } else {
            return null;
        }
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
    
}

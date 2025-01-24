package com.mouradev.ToNaLista.controllers;

import com.mouradev.ToNaLista.models.Employee;
import com.mouradev.ToNaLista.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<List<Employee>> findAllByCompanyId(@PathVariable Integer companyId) {
        return ResponseEntity.ok(employeeService.findAllByCompanyId(companyId));
    }

    @GetMapping("/{companyId}/{cpf}")
    public ResponseEntity<Employee> findByCpf( @PathVariable Integer companyId, @PathVariable String cpf) {
        return ResponseEntity.ok(employeeService.findByCpf(cpf, companyId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> editEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.editEmployee(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

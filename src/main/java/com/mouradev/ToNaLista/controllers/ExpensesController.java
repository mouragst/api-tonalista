package com.mouradev.ToNaLista.controllers;

import com.mouradev.ToNaLista.models.Expenses;
import com.mouradev.ToNaLista.services.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
@CrossOrigin(origins = "*")
public class ExpensesController {
    
    @Autowired
    private ExpensesService expensesService;

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Expenses>> findAllByEventId(@PathVariable Integer eventId) {
        return ResponseEntity.ok(expensesService.findAllByEventId(eventId));
    }

    @PostMapping
    public ResponseEntity<Expenses> addExpenses(@RequestBody Expenses expenses) {
        return ResponseEntity.ok(expensesService.addExpenses(expenses));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expenses> editExpenses(@PathVariable Long id, @RequestBody Expenses expenses) {
        return ResponseEntity.ok(expensesService.editExpenses(id, expenses));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        expensesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

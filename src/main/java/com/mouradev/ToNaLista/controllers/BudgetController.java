package com.mouradev.ToNaLista.controllers;

import com.mouradev.ToNaLista.models.Budget;
import com.mouradev.ToNaLista.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budget")
@CrossOrigin(origins = "*")
public class BudgetController {
    
    @Autowired
    private BudgetService budgetService;

    @PostMapping
    public ResponseEntity<Budget> addBudget(@RequestBody Budget budget) {
        return ResponseEntity.ok(budgetService.addBudget(budget));
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<List<Budget>> findAllByEventId(@PathVariable Integer eventId) {
        return ResponseEntity.ok(budgetService.findAllByEventId(eventId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Budget> editBudget(@PathVariable Long id, @RequestBody Budget budget) {
        return ResponseEntity.ok(budgetService.editBudget(id, budget));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        budgetService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

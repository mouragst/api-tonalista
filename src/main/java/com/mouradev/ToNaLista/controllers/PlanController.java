package com.mouradev.ToNaLista.controllers;

import com.mouradev.ToNaLista.models.Plan;
import com.mouradev.ToNaLista.services.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan")
@CrossOrigin(origins = "*")
public class PlanController {
    
    @Autowired
    private PlanService planService;

    @GetMapping
    public ResponseEntity<List<Plan>> findAll() {
        return ResponseEntity.ok(planService.findAll());
    }

    @PostMapping
    public ResponseEntity<Plan> save(@RequestBody Plan plan) {
        return ResponseEntity.ok(planService.addPlan(plan));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plan> update(@PathVariable Long id, @RequestBody Plan plan) {
        return ResponseEntity.ok(planService.editPlan(id, plan));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        planService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

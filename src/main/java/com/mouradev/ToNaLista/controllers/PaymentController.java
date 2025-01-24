package com.mouradev.ToNaLista.controllers;

import com.mouradev.ToNaLista.models.Payment;
import com.mouradev.ToNaLista.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "*")
public class PaymentController {
    
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/budget/{id}")
    public ResponseEntity<List<Payment>> findAllByBudgetId(@RequestParam Integer budgetId) {
        return ResponseEntity.ok(paymentService.findAllByBudgetId(budgetId));
    }

    @PostMapping
    public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
        return ResponseEntity.ok(paymentService.addPayment(payment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        return ResponseEntity.ok(paymentService.editPayment(id, payment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

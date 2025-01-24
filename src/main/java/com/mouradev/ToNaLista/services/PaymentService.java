package com.mouradev.ToNaLista.services;

import org.springframework.stereotype.Service;
import com.mouradev.ToNaLista.models.Payment;
import com.mouradev.ToNaLista.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PaymentService {
    
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> findAllByBudgetId(Integer budgetId) {
        return paymentRepository.findAllByBudgetId(budgetId);
    }

    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment editPayment(Long id, Payment payment) {
        Payment oldPayment = paymentRepository.findById(id).orElse(null);
        if (oldPayment != null) {
            oldPayment.setEvent(oldPayment.getEvent()); // usuario não pode alterar
            oldPayment.setCompany(oldPayment.getCompany()); // usuario não pode alterar
            oldPayment.setSupplier(payment.getSupplier());
            oldPayment.setBudget(oldPayment.getBudget()); // usuário não pode alterar
            oldPayment.setExpenses(oldPayment.getExpenses()); // usuário não pode alterar
            oldPayment.setValue(payment.getValue());
            oldPayment.setPaidAt(payment.getPaidAt());
            oldPayment.setPaidBy(payment.getPaidBy());
            oldPayment.setPaymentMethod(payment.getPaymentMethod());
            oldPayment.setReceipt(payment.getReceipt());
            oldPayment.setStatus(payment.getStatus());
            oldPayment.setCreatedAt(payment.getCreatedAt());
            return paymentRepository.save(oldPayment);
        } else {
            return null;
        }
    }

    public void deleteById(Long id) {
        paymentRepository.deleteById(id);
    }
}

package com.mouradev.ToNaLista.services;

import org.springframework.stereotype.Service;
import com.mouradev.ToNaLista.models.Budget;
import com.mouradev.ToNaLista.repositories.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class BudgetService {
    
    @Autowired
    private BudgetRepository budgetRepository;

    public List<Budget> findAllByEventId(Integer eventId) {
        return budgetRepository.findAllByEventId(eventId);
    }

    public Budget addBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public Budget editBudget(Long id, Budget budget) {
        Budget oldBudget = budgetRepository.findById(id).orElse(null);
        if (oldBudget != null) {
            oldBudget.setEvent(oldBudget.getEvent()); // usuario não pode alterar
            oldBudget.setCompany(oldBudget.getCompany()); // usuario não pode alterar
            oldBudget.setTotalValue(budget.getTotalValue());
            oldBudget.setValueRemaining(budget.getValueRemaining());
            oldBudget.setDescription(budget.getDescription());
            return budgetRepository.save(oldBudget);
        } else {
            return null;
        }
    }

    public void deleteById(Long id) {
        budgetRepository.deleteById(id);
    }
}

package com.mouradev.ToNaLista.services;

import org.springframework.stereotype.Service;
import com.mouradev.ToNaLista.models.Expenses;
import com.mouradev.ToNaLista.repositories.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ExpensesService {
    
    @Autowired
    private ExpensesRepository expensesRepository;

    public List<Expenses> findAllByEventId(Integer eventId) {
        return expensesRepository.findAllByEventId(eventId);
    }

    public Expenses addExpenses(Expenses expenses) {
        return expensesRepository.save(expenses);
    }

    public Expenses editExpenses(Long id, Expenses expenses) {
        Expenses oldExpenses = expensesRepository.findById(id).orElse(null);
        if (oldExpenses != null) {
            oldExpenses.setEvent(oldExpenses.getEvent()); // usuario não pode editar
            oldExpenses.setCompany(oldExpenses.getCompany()); // usuario não pode editar
            oldExpenses.setSupplier(expenses.getSupplier());
            oldExpenses.setBudget(oldExpenses.getBudget()); // usuario não pode editar
            oldExpenses.setValue(expenses.getValue());
            oldExpenses.setContract(expenses.getContract());
            return expensesRepository.save(oldExpenses);
        } else {
            return null;
        }
    }

    public void deleteById(Long id) {
        expensesRepository.deleteById(id);
    }
}

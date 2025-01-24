package com.mouradev.ToNaLista.services;

import org.springframework.stereotype.Service;
import com.mouradev.ToNaLista.models.Plan;
import com.mouradev.ToNaLista.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;

    public List<Plan> findAll() {
        return planRepository.findAll();
    }

    public Plan addPlan(Plan plan) {
        return planRepository.save(plan);
    }

    public Plan editPlan(Long id, Plan plan) {
        Plan oldPlan = planRepository.findById(id).orElse(null);
        if (oldPlan != null) {
            oldPlan.setName(plan.getName());
            oldPlan.setDescription(plan.getDescription());
            oldPlan.setValue(plan.getValue());
            oldPlan.setExpiration(plan.getExpiration());
            oldPlan.setStatus(plan.getStatus());
            oldPlan.setUserLimit(plan.getUserLimit());
            oldPlan.setCompanyLimit(plan.getCompanyLimit());
            oldPlan.setCreatedAt(plan.getCreatedAt());
            oldPlan.setUpdatedAt(plan.getUpdatedAt());
            return planRepository.save(oldPlan);
        } else {
            return null;
        }
    }

    public void deleteById(Long id) {
        planRepository.deleteById(id);
    }

}

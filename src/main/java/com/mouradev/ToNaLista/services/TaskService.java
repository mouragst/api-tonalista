package com.mouradev.ToNaLista.services;

import org.springframework.stereotype.Service;
import com.mouradev.ToNaLista.models.Task;
import com.mouradev.ToNaLista.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> findAllByEventId(Integer eventId) {
        return taskRepository.findAllByEventId(eventId);
    }

    public Task editTask(Long id, Task task) {
        Task oldTask = taskRepository.findById(id).orElse(null);
    
        if (oldTask != null) {
            oldTask.setEvent(oldTask.getEvent()); // usuario não pode alterar
            oldTask.setCompany(oldTask.getCompany()); // usuario não pode alterar
            oldTask.setSupplier(task.getSupplier());
            oldTask.setName(task.getName());
            oldTask.setDescription(task.getDescription());
            oldTask.setNotificateAt(task.getNotificateAt());
            oldTask.setShowToCustomer(task.isShowToCustomer());
            oldTask.setCustomerResponsability(task.isCustomerResponsability());
            oldTask.setDate(task.getDate());
            oldTask.setStatus(task.getStatus());
            return taskRepository.save(oldTask);
        } else {
            return null;
        }
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
    
}

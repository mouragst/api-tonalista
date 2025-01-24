package com.mouradev.ToNaLista.controllers;

import com.mouradev.ToNaLista.models.Task;
import com.mouradev.ToNaLista.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins = "*")
public class TaskController {
    
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.addTask(task));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Task>> findTaskByEventId(@PathVariable Integer id) {
        return ResponseEntity.ok(taskService.findAllByEventId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.editTask(id, task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

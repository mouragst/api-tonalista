package com.mouradev.ToNaLista.controllers;

import com.mouradev.ToNaLista.models.Schedule;
import com.mouradev.ToNaLista.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@CrossOrigin(origins = "*")
public class ScheduleController {
    
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<Schedule> addSchedule(@RequestBody Schedule schedule) {
        return ResponseEntity.ok(scheduleService.addSchedule(schedule));
    }

    @GetMapping("/event/{id}")
    public ResponseEntity<List<Schedule>> findAllByEventId(@PathVariable Integer id) {
        return ResponseEntity.ok(scheduleService.findAllByEventId(id));
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<List<Schedule>> findAllByEmployeeId(@PathVariable Integer id) {
        return ResponseEntity.ok(scheduleService.findAllByEmployeeId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> editSchedule(@PathVariable Long id, @RequestBody Schedule schedule) {
        return ResponseEntity.ok(scheduleService.editSchedule(id, schedule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        scheduleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

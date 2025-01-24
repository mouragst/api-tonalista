package com.mouradev.ToNaLista.controllers;

import com.mouradev.ToNaLista.models.Event;
import com.mouradev.ToNaLista.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.time.LocalDate;

@RestController
@RequestMapping("/event")
@CrossOrigin(origins = "*")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Event>> findAllByDate(@PathVariable LocalDate date, @RequestParam Integer companyId) {
        return ResponseEntity.ok(eventService.findAllByDate(date, companyId));
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<List<Event>> findAllEventsByCompany(@PathVariable Integer companyId) {
        return ResponseEntity.ok(eventService.findAllEventsByCompany(companyId));
    }

    @PostMapping
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.addEvent(event));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> editEvent(@PathVariable Long id, @RequestBody Event event) {
        return ResponseEntity.ok(eventService.editEvent(id, event));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        eventService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

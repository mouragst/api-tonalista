package com.mouradev.ToNaLista.controllers;

import com.mouradev.ToNaLista.models.Guest;
import com.mouradev.ToNaLista.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guest")
@CrossOrigin(origins = "*")
public class GuestController {
    
    @Autowired
    private GuestService guestService;

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Guest>> findAllByEventId(@PathVariable Integer eventId) {
        return ResponseEntity.ok(guestService.findAllByEventId(eventId));
    }

    @PostMapping
    public ResponseEntity<Guest> addGuest(@RequestBody Guest guest) {
        return ResponseEntity.ok(guestService.addGuest(guest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guest> editGuest(@PathVariable Long id, @RequestBody Guest guest) {
        return ResponseEntity.ok(guestService.editGuest(id, guest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        guestService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

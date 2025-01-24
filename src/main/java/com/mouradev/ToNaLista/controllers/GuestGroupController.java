package com.mouradev.ToNaLista.controllers;

import com.mouradev.ToNaLista.models.GuestGroup;
import com.mouradev.ToNaLista.services.GuestGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guest-group")
@CrossOrigin(origins = "*")
public class GuestGroupController {
    
    @Autowired
    private GuestGroupService guestGroupService;

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<GuestGroup>> findAllByEventId(@PathVariable Integer eventId) {
        return ResponseEntity.ok(guestGroupService.findAllByEventId(eventId));
    }

    @PostMapping
    public ResponseEntity<GuestGroup> addGuestGroup(@RequestBody GuestGroup guestGroup) {
        return ResponseEntity.ok(guestGroupService.addGuestGroup(guestGroup));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuestGroup> editGuestGroup(@PathVariable Long id, @RequestBody GuestGroup guestGroup) {
        return ResponseEntity.ok(guestGroupService.editGuestGroup(id, guestGroup));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        guestGroupService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

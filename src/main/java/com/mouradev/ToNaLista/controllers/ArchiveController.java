package com.mouradev.ToNaLista.controllers;

import com.mouradev.ToNaLista.models.Archive;
import com.mouradev.ToNaLista.services.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/file")
@CrossOrigin(origins = "*")
public class ArchiveController {

    @Autowired
    private ArchiveService archiveService;

    @GetMapping("/{eventId}")
    public ResponseEntity<List<Archive>> findAllByEventId(@PathVariable Integer eventId) {
        return ResponseEntity.ok(archiveService.findAllByEventId(eventId));
    }
}

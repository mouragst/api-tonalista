package com.mouradev.ToNaLista.controllers;

import com.mouradev.ToNaLista.models.Location;
import com.mouradev.ToNaLista.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
@CrossOrigin(origins = "*")
public class LocationController {
 
    @Autowired
    private LocationService locationService;

    @GetMapping("/{companyId}")
    public ResponseEntity<List<Location>> findAllLocations(@PathVariable Integer companyId) {
        return ResponseEntity.ok(locationService.findAllLocations(companyId));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Location>> findAllByCategoryId(@RequestParam Integer categoryId) {
        return ResponseEntity.ok(locationService.findAllByCategoryId(categoryId));
    }

    @PostMapping
    public ResponseEntity<Location> addLocation(@RequestBody Location location) {
        return ResponseEntity.ok(locationService.addLocation(location));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody Location location) {
        return ResponseEntity.ok(locationService.editLocation(id, location));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        locationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

package com.mouradev.ToNaLista.services;


import org.springframework.stereotype.Service;
import com.mouradev.ToNaLista.models.Location;
import com.mouradev.ToNaLista.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class LocationService {
    
    @Autowired
    private LocationRepository locationRepository;

    public List<Location> findAllByCategoryId(Integer categoryId) {
        return locationRepository.findAllByCategoryId(categoryId);
    }

    public List<Location> findAllLocations(Integer companyId) {
        return locationRepository.findAllByCompanyId(companyId);
    }

    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location editLocation(Long id, Location location) {
        Location oldLocation = locationRepository.findById(id).orElse(null);
        if (oldLocation != null) {
            oldLocation.setName(location.getName());
            oldLocation.setDescription(location.getDescription());
            oldLocation.setCategory(location.getCategory());
            oldLocation.setPhoneNumber(location.getPhoneNumber());
            oldLocation.setEmail(location.getEmail());
            oldLocation.setAddress(location.getAddress());
            oldLocation.setCep(location.getCep());
            oldLocation.setCity(location.getCity());
            oldLocation.setState(location.getState());
            oldLocation.setCountry(location.getCountry());
            oldLocation.setReference(location.getReference());
            oldLocation.setAnnotation(location.getAnnotation());
            oldLocation.setQualification(location.getQualification());
            oldLocation.setCreatedAt(location.getCreatedAt());
            oldLocation.setUpdatedAt(location.getUpdatedAt());
            return locationRepository.save(oldLocation);
        } else {
            return null;
        }
    }

    public void deleteById(Long id) {
        locationRepository.deleteById(id);
    }
}

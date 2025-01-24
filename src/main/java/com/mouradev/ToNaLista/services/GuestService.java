package com.mouradev.ToNaLista.services;

import org.springframework.stereotype.Service;
import com.mouradev.ToNaLista.models.Guest;
import com.mouradev.ToNaLista.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class GuestService {
    
    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> findAllByEventId(Integer eventId) {
        return guestRepository.findAllByEventId(eventId);
    }

    public Guest addGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public Guest editGuest(Long id, Guest guest) {
        Guest oldGuest = guestRepository.findById(id).orElse(null);
        if (oldGuest != null) {
            oldGuest.setEvent(oldGuest.getEvent()); // usuario não pode editar
            oldGuest.setCompany(oldGuest.getCompany()); // usuario não pode editar
            oldGuest.setName(guest.getName());
            oldGuest.setSurname(guest.getSurname());
            oldGuest.setCompanion(guest.getCompanion());
            oldGuest.setTable(guest.getTable());
            oldGuest.setAnnotation(guest.getAnnotation());
            oldGuest.setGender(guest.getGender());
            oldGuest.setAge(guest.getAge());
            oldGuest.setEmail(guest.getEmail());
            oldGuest.setPhoneNumber(guest.getPhoneNumber());
            oldGuest.setGuestGroup(guest.getGuestGroup());
            oldGuest.setStatus(guest.getStatus());
            return guestRepository.save(oldGuest);
        } else {
            return null;
        }
    }

    public void deleteById(Long id) {
        guestRepository.deleteById(id);
    }
}

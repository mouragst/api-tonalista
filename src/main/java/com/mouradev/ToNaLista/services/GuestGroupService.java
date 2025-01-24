package com.mouradev.ToNaLista.services;

import org.springframework.stereotype.Service;
import com.mouradev.ToNaLista.models.GuestGroup;
import com.mouradev.ToNaLista.repositories.GuestGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class GuestGroupService {
    
    @Autowired
    private GuestGroupRepository guestGroupRepository;

    public List<GuestGroup> findAllByEventId(Integer eventId) {
        return guestGroupRepository.findAllByEventId(eventId);
    }

    public GuestGroup addGuestGroup(GuestGroup guestGroup) {
        return guestGroupRepository.save(guestGroup);
    }

    public GuestGroup editGuestGroup(Long id, GuestGroup guestGroup) {
        GuestGroup oldGuestGroup = guestGroupRepository.findById(id).orElse(null);
        if (oldGuestGroup != null) {
            oldGuestGroup.setEvent(oldGuestGroup.getEvent()); // usuario não pode editar
            oldGuestGroup.setCompany(oldGuestGroup.getCompany()); // usuario não pode editar
            oldGuestGroup.setName(guestGroup.getName());
            oldGuestGroup.setStatus(guestGroup.getStatus());
            return guestGroupRepository.save(oldGuestGroup);
        } else {
            return null;
        }
    }

    public void deleteById(Long id) {
        guestGroupRepository.deleteById(id);
    }
}

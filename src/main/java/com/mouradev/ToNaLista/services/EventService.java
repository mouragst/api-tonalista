package com.mouradev.ToNaLista.services;

import org.springframework.stereotype.Service;
import com.mouradev.ToNaLista.models.Event;
import com.mouradev.ToNaLista.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> findAllByDate(LocalDate date, Integer companyId) {
        return eventRepository.findAllByDateAndCompanyId(date, companyId);
    }

    public List<Event> findAllEventsByCompany(Integer companyId) {
        return eventRepository.findAllByCompany(companyId);
    }
    
    public Event editEvent(Long id, Event event) {
        Event oldEvent = eventRepository.findById(id).orElse(null);
        if (oldEvent != null) {
            oldEvent.setCompany(oldEvent.getCompany()); // usuario não pode editar
            oldEvent.setName(event.getName());
            oldEvent.setDescription(event.getDescription());
            oldEvent.setDate(event.getDate());
            oldEvent.setStartTime(event.getStartTime());
            oldEvent.setEndTime(event.getEndTime());
            oldEvent.setConfirmTillDate(event.getConfirmTillDate());
            oldEvent.setLocation(event.getLocation());
            oldEvent.setAddress(event.getAddress());
            oldEvent.setStatus(event.getStatus());
            return eventRepository.save(oldEvent);
        } else {
            return null;
        }
    }

    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }
}

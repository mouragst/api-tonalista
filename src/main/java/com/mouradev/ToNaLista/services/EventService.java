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

    public Event registerEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> findAllByDate(LocalDate date) {
        return eventRepository.findAllByDate(date);
    }

    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }
}

package com.mouradev.ToNaLista.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mouradev.ToNaLista.models.Event;

import java.util.List;
import java.time.LocalDate;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    
    List<Event> findAllByDate(LocalDate date);
    
}

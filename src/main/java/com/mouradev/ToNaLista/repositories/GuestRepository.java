package com.mouradev.ToNaLista.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mouradev.ToNaLista.models.Guest;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    
    List<Guest> findAllByEventId(Integer eventId);
    
}

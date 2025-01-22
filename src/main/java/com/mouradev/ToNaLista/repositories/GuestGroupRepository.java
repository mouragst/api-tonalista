package com.mouradev.ToNaLista.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mouradev.ToNaLista.models.GuestGroup;

import java.util.List;

@Repository
public interface GuestGroupRepository extends JpaRepository<GuestGroup, Long> {
    
    List<GuestGroup> findAllByEventId(Integer eventId);
    
}

package com.mouradev.ToNaLista.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mouradev.ToNaLista.models.Archive;

import java.util.List;

@Repository
public interface ArchiveRepository extends JpaRepository<Archive, Long> {
    
    List<Archive> findAllByEventId(Integer eventId);
}

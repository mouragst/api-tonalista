package com.mouradev.ToNaLista.services;

import org.springframework.stereotype.Service;
import com.mouradev.ToNaLista.models.Archive;
import com.mouradev.ToNaLista.repositories.ArchiveRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ArchiveService {
    
    @Autowired
    private ArchiveRepository archiveRepository;

    public List<Archive> findAllByEventId(Integer eventId) {
        return archiveRepository.findAllByEventId(eventId);
    }
}

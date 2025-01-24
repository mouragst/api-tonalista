package com.mouradev.ToNaLista.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mouradev.ToNaLista.models.Schedule;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    
    List<Schedule> findAllByEmployeeId(Integer employeeId);
    List<Schedule> findAllByEventId(Integer eventId);
    
}

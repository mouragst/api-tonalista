package com.mouradev.ToNaLista.services;

import org.springframework.stereotype.Service;
import com.mouradev.ToNaLista.models.Schedule;
import com.mouradev.ToNaLista.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule addSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public Schedule editSchedule(Long id, Schedule schedule) {
        Schedule oldSchedule = scheduleRepository.findById(id).orElse(null);
        if (oldSchedule != null) {
            oldSchedule.setEmployee(schedule.getEmployee());
            oldSchedule.setCompany(oldSchedule.getCompany()); // usuario não pode alterar
            oldSchedule.setEvent(schedule.getEvent());
            oldSchedule.setDate(schedule.getDate());
            oldSchedule.setPayment(schedule.getPayment());
            oldSchedule.setStatus(schedule.getStatus());
            oldSchedule.setCreatedAt(schedule.getCreatedAt());
            oldSchedule.setUpdatedAt(schedule.getUpdatedAt());
            return scheduleRepository.save(oldSchedule);
        } else {
            return null;
        }
    }

    public void deleteById(Long id) {
        scheduleRepository.deleteById(id);
    }

    public List<Schedule> findAllByEmployeeId(Integer employeeId) {
        return scheduleRepository.findAllByEmployeeId(employeeId);
    }

    public List<Schedule> findAllByEventId(Integer eventId) {
        return scheduleRepository.findAllByEventId(eventId);
    }
    
}

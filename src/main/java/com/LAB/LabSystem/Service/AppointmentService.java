package com.LAB.LabSystem.Service;

import com.LAB.LabSystem.Entitiy.Appointment;
import com.LAB.LabSystem.Repo.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepo appointmentRepo;
    public void appointmentSave(Appointment appointments) {
        appointmentRepo.save(appointments);
    }

    public Iterable<Appointment> listAll() {
        return this.appointmentRepo.findAll();
    }

    public void deleteAppointment(String id) {
        appointmentRepo.deleteById(id);
    }
}

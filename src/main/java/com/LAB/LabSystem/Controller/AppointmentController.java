package com.LAB.LabSystem.Controller;

import com.LAB.LabSystem.Entitiy.Appointment;
import com.LAB.LabSystem.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping( "api2/V2/Appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @PostMapping(value = "/appointmentSave")
    private String appointmentSave(@RequestBody Appointment appointments){
        appointmentService.appointmentSave(appointments);
        return appointments.getPatientName();

    }
    @GetMapping(value="/allAppointments")
    public Iterable<Appointment> getAppointments() {
        return appointmentService.listAll();
    }
    @DeleteMapping(value="/delete/{ID}")
    private void DeleteAppointment(@PathVariable("Id")String id){
        appointmentService.deleteAppointment(id);
    }

}

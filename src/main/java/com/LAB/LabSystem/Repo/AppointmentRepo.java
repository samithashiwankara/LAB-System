package com.LAB.LabSystem.Repo;

import com.LAB.LabSystem.Entitiy.Appointment;
import com.LAB.LabSystem.Entitiy.Register;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends MongoRepository<Appointment,String> {
}

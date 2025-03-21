package nlu.com.app.repository;

import nlu.com.app.entity.Appointment;
import nlu.com.app.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}

package nlu.com.app.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Appointments")
@Inheritance(strategy = InheritanceType.JOINED)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    Patient patient;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    Doctor doctor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}

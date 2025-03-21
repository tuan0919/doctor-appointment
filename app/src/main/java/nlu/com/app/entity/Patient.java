package nlu.com.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Table(name = "Patients")
@Data
@PrimaryKeyJoinColumn(name = "user_id")
@Entity
public class Patient extends User {
    LocalDate dateOfBirth;
    String gender;
    @Column(columnDefinition = "TEXT")
    String medicalHistory;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    Set<Appointment> appointments;

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }
}

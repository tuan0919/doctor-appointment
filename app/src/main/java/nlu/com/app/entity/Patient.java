package nlu.com.app.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Table(name = "Patients")
@Getter @Setter
@PrimaryKeyJoinColumn(name = "user_id")
@Entity
public class Patient extends User {
    LocalDate dateOfBirth;
    String gender;
    @Column(columnDefinition = "TEXT")
    String medicalHistory;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    Set<Appointment> appointments;
}
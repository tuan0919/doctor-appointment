package nlu.com.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Table(name = "Doctors")
@Data
@PrimaryKeyJoinColumn(name = "user_id")
@Entity
public class Doctor extends User {
    private String specialization;
    private int experience;
    private String qualification;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
    Set<Appointment> appointments;
}
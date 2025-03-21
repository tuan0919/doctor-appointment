package nlu.com.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(name = "Doctors")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "user_id")
@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Doctor extends User {
    private String specialization;
    private int experience;
    private String qualification;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
    Set<Appointment> appointments;

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }
}

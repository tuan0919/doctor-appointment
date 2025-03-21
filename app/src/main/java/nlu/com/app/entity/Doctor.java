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
}
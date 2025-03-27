package nlu.com.app.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import nlu.com.app.enums.Accident;
import nlu.com.app.enums.Specialty;

@Table(name = "Doctors")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "user_id")
@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Doctor extends User {
  @Enumerated(value = EnumType.STRING)
  private Specialty specialization;
  private int experience;
  private String qualification;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
  Set<Appointment> appointments;
  private String bio;
  private float avgRating;
  private float price;
  @Enumerated(value = EnumType.STRING)
  private Accident accident;
  private String education;
  private int visits;
}

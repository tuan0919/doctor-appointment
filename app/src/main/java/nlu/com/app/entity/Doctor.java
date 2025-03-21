package nlu.com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import nlu.com.app.enums.Accident;

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
  private String specialization;
  private int experience;
  private String qualification;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
  Set<Appointment> appointments;
  private String bio;
  private float avgRating;
  private float price;
  @Enumerated(value = EnumType.STRING)
  private Accident accident;

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

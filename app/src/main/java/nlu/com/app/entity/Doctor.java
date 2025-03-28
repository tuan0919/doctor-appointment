package nlu.com.app.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Table(name = "Doctors")
@Getter
@Setter
@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Doctor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  private int experience;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
  Set<Appointment> appointments;
  private String bio;
  private String name;
  private String thumbnail;
  private float avgRating;
  private String hospital;
  private int price;
  private String education;
  private int visits;
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
          name = "doctor_specialty",
          joinColumns = {@JoinColumn(name = "doctor_id")},
          inverseJoinColumns = {@JoinColumn(name = "specialty_id")}
  )
  private List<Specialty> specialties;

  @OneToOne
  private User user;
}

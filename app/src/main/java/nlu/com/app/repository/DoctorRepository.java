package nlu.com.app.repository;

import nlu.com.app.entity.Doctor;
import nlu.com.app.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
  List<Doctor> findBySpecialtiesContains(Specialty specialty);
  List<Doctor> findBySpecialtiesIn(Set<Specialty> specialties);
}

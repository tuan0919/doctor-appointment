package nlu.com.app.repository;

import java.util.List;
import nlu.com.app.entity.Doctor;
import nlu.com.app.enums.Accident;
import nlu.com.app.enums.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findBySpecialization(Specialty specialty);
    List<Doctor> findAllByAccident(Accident accident);
}

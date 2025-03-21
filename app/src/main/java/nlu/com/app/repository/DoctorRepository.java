package nlu.com.app.repository;

import java.util.List;
import nlu.com.app.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

  @Query("""
    SELECT d FROM Doctor d 
    WHERE d.specialization LIKE %:specialization%
""")
  List<Doctor> findAllBySpecialization(String specialization);
}

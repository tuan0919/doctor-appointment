package nlu.com.app.repository;

import nlu.com.app.entity.Doctor;
import nlu.com.app.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends JpaRepository<Specialty, Long> {

}

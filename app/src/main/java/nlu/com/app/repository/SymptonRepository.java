package nlu.com.app.repository;

import nlu.com.app.entity.Specialty;
import nlu.com.app.entity.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SymptonRepository extends JpaRepository<Symptom, Long> {
    Optional<Symptom> findFirstByNameContainingIgnoreCase(String name);
    List<Symptom> findAllByNameContainingIgnoreCase(String name);
}

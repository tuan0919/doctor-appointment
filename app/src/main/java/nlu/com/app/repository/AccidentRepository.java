package nlu.com.app.repository;

import nlu.com.app.entity.Accident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccidentRepository extends JpaRepository<Accident, Long> {
    List<Accident> findAllByNameContainingIgnoreCase(String name);
}

package nlu.com.app.repository;

import nlu.com.app.entity.Role;
import nlu.com.app.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}

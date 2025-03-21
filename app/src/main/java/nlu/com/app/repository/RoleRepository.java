package nlu.com.app.repository;

import nlu.com.app.entity.Role;
import nlu.com.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {

}

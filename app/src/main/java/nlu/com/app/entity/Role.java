package nlu.com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Table(name = "Roles")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "UserRoles",
      joinColumns = {@JoinColumn(name = "role_id")},
      inverseJoinColumns = {@JoinColumn(name = "user_id")}
  )
  Set<User> users;
}

package nlu.com.app.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Users")
@Inheritance(strategy = InheritanceType.JOINED)
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    Set<Role> roles;
    String firstName;
    String lastName;
    String email;
    String password;
    String phone;
    String address;
    @Column(name = "create_at")
    LocalDateTime createdAt;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    Set<Image> images;
}

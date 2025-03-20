package nlu.com.app.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Images")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Image {
    @Id
    Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    User user;
    String url;
    String type;
    @Column(name = "create_at")
    LocalDateTime createdAt;
}

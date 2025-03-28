package nlu.com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Doctor doctor;
    private LocalDate date;
    private int startTime;
    private int endTime;
    private boolean available;
    private int maxPatients;
}

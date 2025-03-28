package nlu.com.app.mapper;

import nlu.com.app.dto.response.DoctorDetailsDTO;
import nlu.com.app.entity.Doctor;
import nlu.com.app.entity.Schedule;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DoctorMapper {

    public DoctorDetailsDTO toDoctorDetailsDTO(Doctor doctor) {
        return DoctorDetailsDTO.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .image(doctor.getThumbnail())
                .specialties(doctor.getSpecialties().stream()
                        .map(s -> s.getName())
                        .collect(Collectors.joining(", ")))
                .avgRating(doctor.getAvgRating())
                .price(doctor.getPrice())
                .introduction(doctor.getBio())
                .experience(doctor.getExperience())
                .schedules(mapSchedules(doctor.getSchedules()))
                .build();
    }

    private Map<String, List<DoctorDetailsDTO.Time>> mapSchedules(List<Schedule> schedules) {
        return schedules.stream()
                .collect(Collectors.groupingBy(
                        schedule -> schedule.getDate().toString(),
                        Collectors.mapping(schedule -> DoctorDetailsDTO.Time.builder()
                                .start(schedule.getStartTime())
                                .end(schedule.getEndTime())
                                .maxPatients(schedule.getMaxPatients())
                                .build(), Collectors.toList())
                ));
    }
}
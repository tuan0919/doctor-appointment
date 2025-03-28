package nlu.com.app.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Data
@FieldDefaults(level =  AccessLevel.PRIVATE)
@Builder
public class DoctorDetailsDTO {
    long id;
    String name;
    String image;
    String specialties;
    float avgRating;
    int price;
    String introduction;
    Map<String, List<Time>> schedules;
    int experience;

    @Data
    @Builder
    public static class Time {
        int start;
        int end;
        int maxPatients;
    }
}
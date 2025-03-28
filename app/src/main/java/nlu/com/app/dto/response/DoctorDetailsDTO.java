package nlu.com.app.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;

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
    Schedules schedules;
    int experience;

    @Data
    @Builder
    public static class Schedules {
        List<Integer> mon;
        List<Integer> tue;
        List<Integer> wed;
        List<Integer> thu;
        List<Integer> fri;
        List<Integer> sat;
        List<Integer> sun;
    }
}

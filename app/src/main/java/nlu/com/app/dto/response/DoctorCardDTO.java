package nlu.com.app.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level =  AccessLevel.PRIVATE)
@Builder
public class DoctorCardDTO {
    Long id;
    String name;
    String specialization;
    String thumbnail;
    String hospital;
    Float ratings;
    Integer price;
    Integer visit;
}

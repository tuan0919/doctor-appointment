package nlu.com.app.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level =  AccessLevel.PRIVATE)
@Builder
public class DoctorRegisterResponseDTO {
    Long id;
}

package nlu.com.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSearchResponseDTO {
  Long id;
  String name;
  String specialization;
  String address;
  String img;
}

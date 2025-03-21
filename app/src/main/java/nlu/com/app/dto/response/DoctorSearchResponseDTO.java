package nlu.com.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorSearchResponseDTO {
  Long id;
  String name;
  String specialization;
  String address;
  float price;
  float avgRating;
  String img;
}

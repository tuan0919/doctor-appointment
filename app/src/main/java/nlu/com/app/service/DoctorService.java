package nlu.com.app.service;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import nlu.com.app.dto.response.DoctorSearchResponseDTO;
import nlu.com.app.repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DoctorService {

  DoctorRepository doctorRepository;

  public List<DoctorSearchResponseDTO> searchDoctorSpecialization(String specialization) {
    var response = doctorRepository.findAllBySpecialization(specialization);
    List<DoctorSearchResponseDTO> responseDTOS = new ArrayList<>();
    response.forEach(data -> {
      responseDTOS.add(DoctorSearchResponseDTO
          .builder()
          .id(data.getId())
          .address(data.getAddress())
          .name(data.getLastName() + " " + data.getFirstName())
          .specialization(data.getSpecialization())
          .img(String.valueOf(
              data.getImages().stream().filter(image -> Boolean.parseBoolean(image.getUrl()))
                  .findFirst()))
          .build());
    });
    return responseDTOS;
  }
}

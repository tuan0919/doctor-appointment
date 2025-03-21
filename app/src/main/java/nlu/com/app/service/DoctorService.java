package nlu.com.app.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nlu.com.app.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
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

    public List<DoctorCardDTO> listDoctors() {
        return doctorRepository.findAll().stream()
                .map(doctor -> DoctorCardDTO.builder()
                        .name(doctor.getFirstName() + doctor.getLastName())
                        .thumbnail(doctor.getImages().stream().findFirst().orElse(Image.builder().url("null").build()).getUrl())
                        .ratings(5.3f)
                        .visit(69)
                        .price(0)
                        .specialization(doctor.getSpecialization())
                        .hospital(doctor.getAddress()).build())
                .toList();
    }
}

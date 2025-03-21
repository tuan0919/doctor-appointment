package nlu.com.app.service;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nlu.com.app.dto.response.DoctorCardDTO;
import nlu.com.app.dto.response.DoctorSearchResponseDTO;
import nlu.com.app.entity.Image;
import nlu.com.app.enums.Accident;
import nlu.com.app.repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DoctorService {

  DoctorRepository doctorRepository;

//  public List<DoctorSearchResponseDTO> searchDoctorSpecialization(String specialization) {
//    var response = doctorRepository.findAllBySpecialization(specialization);
//    List<DoctorSearchResponseDTO> responseDTOS = new ArrayList<>();
//    response.forEach(data -> {
//      responseDTOS.add(DoctorSearchResponseDTO
//          .builder()
//          .id(data.getId())
//          .address(data.getAddress())
//          .name(data.getLastName() + " " + data.getFirstName())
//          .specialization(data.getSpecialization().getDescription())
//          .img(String.valueOf(
//              data.getImages().stream()
//                  .findFirst().orElse(Image.builder().url(null).build()).getUrl()))
//          .build());
//    });
//    return responseDTOS;
//  }

  public List<DoctorCardDTO> listDoctors() {
    return doctorRepository.findAll().stream()
        .map(doctor -> DoctorCardDTO.builder()
            .id(doctor.getId())
            .name(doctor.getFirstName() + doctor.getLastName())
            .thumbnail(
                doctor.getImages().stream().findFirst().orElse(Image.builder().url("null").build())
                    .getUrl())
            .ratings(5.3f)
            .visit(69)
            .price(0)
            .specialization(doctor.getSpecialization().getDescription())
            .hospital(doctor.getAddress()).build())
        .toList();
  }

  public List<DoctorSearchResponseDTO> searchDoctorByAccident(String keyword) {
    var key = Accident.findSpecialtyEnumByAccident(keyword);
    var doctor = doctorRepository.findAllByAccident(key);

    if (doctor.size() < 1) {
      return null;
    }

    List<DoctorSearchResponseDTO> responseDTOS = new ArrayList<>();
    doctor.forEach(data -> {
      responseDTOS.add(DoctorSearchResponseDTO
          .builder()
          .id(data.getId())
          .address(data.getAddress())
          .name(data.getLastName() + " " + data.getFirstName())
          .specialization(data.getSpecialization().getDescription())
          .img(String.valueOf(
              data.getImages().stream()
                  .findFirst().orElse(Image.builder().url(null).build()).getUrl()))
          .build());
    });

    return responseDTOS;
  }
}

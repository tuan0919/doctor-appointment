package nlu.com.app.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nlu.com.app.dto.response.DoctorCardDTO;
import nlu.com.app.dto.response.DoctorDetailsDTO;
import nlu.com.app.dto.response.DoctorSearchResponseDTO;
import nlu.com.app.entity.Image;
import nlu.com.app.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
          .specialization(data.getSpecialization().getDescription())
          .img(String.valueOf(
              data.getImages().stream()
                  .findFirst().orElse(Image.builder().url(null).build()).getUrl()))
          .build());
    });
    return responseDTOS;
  }

  public DoctorDetailsDTO getDoctorDetailsById(long id) {
    var obj =  doctorRepository.findById(id).get();
    var defaultTime = Arrays.asList(8,9,10,11,12,13,14,15,16,17,18,19,20,21);

    return DoctorDetailsDTO.builder()
            .name(obj.getFirstName() + " " + obj.getLastName())
            .id(obj.getId())
            .price((int) obj.getPrice())
            .image(null)
            .avgRating(obj.getAvgRating())
            .specialties(obj.getSpecialization().getDescription())
            .introduction(obj.getBio())
            .experience(obj.getExperience())
            .schedules(DoctorDetailsDTO.Schedules.builder()
                    .mon(defaultTime)
                    .tue(defaultTime)
                    .wed(defaultTime)
                    .thu(defaultTime)
                    .fri(List.of())
                    .sat(List.of())
                    .sun(List.of()).build())
            .build();
  }

  public List<DoctorCardDTO> listDoctors() {
      return doctorRepository.findAll().stream()
              .map(doctor -> DoctorCardDTO.builder()
                      .id(doctor.getId())
                      .name(doctor.getFirstName() + doctor.getLastName())
                      .thumbnail(doctor.getImages().stream().findFirst().orElse(Image.builder().url("null").build()).getUrl())
                      .ratings(5.3f)
                      .visit(69)
                      .price(0)
                      .specialization(doctor.getSpecialization().getDescription())
                      .hospital(doctor.getAddress()).build())
              .toList();
  }


}

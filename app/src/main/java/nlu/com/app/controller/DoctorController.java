package nlu.com.app.controller;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nlu.com.app.dto.response.DoctorSearchResponseDTO;
import nlu.com.app.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("/doctor")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DoctorController {
  DoctorService doctorService;

  @GetMapping("/search/${specialization}")
  public ResponseEntity<List<DoctorSearchResponseDTO>> searchDoctor(@PathVariable String specialization) {
    List<DoctorSearchResponseDTO> responseDTOS = doctorService.searchDoctorSpecialization(specialization);
    return new ResponseEntity<>(responseDTOS, HttpStatus.OK);
  }
}

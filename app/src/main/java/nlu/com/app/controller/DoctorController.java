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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/doctor")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DoctorController {
  DoctorService doctorService;

  @GetMapping("/search-symptom")
  public ResponseEntity<List<DoctorSearchResponseDTO>> searchDoctorBySymptom(@RequestParam String keyword) {
    List<DoctorSearchResponseDTO> responseDTOS = doctorService.searchDoctorBySymptom(keyword);
    return new ResponseEntity<>(responseDTOS, HttpStatus.OK);
  }
}

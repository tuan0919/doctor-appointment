package nlu.com.app.controller;

import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nlu.com.app.dto.response.ApiResponse;
import nlu.com.app.dto.response.DoctorSearchResponseDTO;
import nlu.com.app.service.DoctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/doctor")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DoctorController {

  DoctorService doctorService;

//  @GetMapping("/doctor/search")
//  public ResponseEntity<List<DoctorSearchResponseDTO>> searchDoctor(@RequestParam String keyword) {
//    List<DoctorSearchResponseDTO> responseDTOS = doctorService.searchDoctorSpecialization(keyword);
//    return new ResponseEntity<>(responseDTOS, HttpStatus.OK);
//  }

  @GetMapping("/search-accident")
  public ApiResponse<List<DoctorSearchResponseDTO>> searchDoctorByAccident(
      @RequestParam String keyword) {
    return doctorService.searchDoctorByAccident(keyword);
  }
}

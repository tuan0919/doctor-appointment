package nlu.com.app.controller;

import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nlu.com.app.dto.response.ApiResponse;
import nlu.com.app.dto.response.DoctorDetailsDTO;
import nlu.com.app.dto.response.DoctorSearchResponseDTO;
import nlu.com.app.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DoctorController {
  DoctorService doctorService;

  @GetMapping("/doctor/symptom/search")
  public ApiResponse<List<DoctorSearchResponseDTO>> searchDoctorBySymptom(@RequestParam String symptom) {
    List<DoctorSearchResponseDTO> responseDTOS = doctorService.searchDoctorsBySymptoms(symptom);
    return ApiResponse.<List<DoctorSearchResponseDTO>>builder()
            .result(responseDTOS)
            .build();
  }

  @GetMapping("/doctor/accident/search")
  public ApiResponse<List<DoctorSearchResponseDTO>> searchDoctorByAccident(@RequestParam String accident) {
    List<DoctorSearchResponseDTO> responseDTOS = doctorService.searchDoctorsByAccidents(accident);
    return ApiResponse.<List<DoctorSearchResponseDTO>>builder()
            .result(responseDTOS)
            .build();
  }

  @GetMapping("/doctor/details")
  public ApiResponse<DoctorDetailsDTO> getDetailsById(@RequestParam long id) {
    System.out.println("OK");
    return ApiResponse.<DoctorDetailsDTO>builder()
            .code(HttpStatus.OK.value())
            .message("OK")
            .result(doctorService.getDoctorDetailsById(id))
            .build();
  }
}

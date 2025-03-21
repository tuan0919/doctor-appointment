package nlu.com.app.controller;

import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nlu.com.app.dto.response.ApiResponse;
import nlu.com.app.dto.response.DoctorSearchResponseDTO;
import nlu.com.app.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

  @GetMapping("/search-accident")
  public ApiResponse<List<DoctorSearchResponseDTO>> searchDoctorByAccident(
      @RequestParam String keyword) {
    var response = doctorService.searchDoctorByAccident(keyword);
    if (response != null) {
      return ApiResponse.<List<DoctorSearchResponseDTO>>builder().result(response).build();
    }
    return ApiResponse.<List<DoctorSearchResponseDTO>>builder()
        .result(null)
        .message("không có dữ liệu")
        .build();
  }

  @GetMapping("/search-symptom")
  public ApiResponse<List<DoctorSearchResponseDTO>> searchDoctorBySymptom(@RequestParam String keyword) {
    List<DoctorSearchResponseDTO> responseDTOS = doctorService.searchDoctorBySymptom(keyword);
    if (responseDTOS == null || responseDTOS.isEmpty()) {
      return ApiResponse.<List<DoctorSearchResponseDTO>>builder()
              .code(HttpStatus.NOT_FOUND.value())
              .message("Not found doctor by symptom")
              .result(null)
              .build();
    }else {
      return ApiResponse.<List<DoctorSearchResponseDTO>>builder()
              .code(HttpStatus.OK.value())
              .message("Success find doctor by symptom")
              .result(responseDTOS)
              .build();
    }
  }
}

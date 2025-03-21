package nlu.com.app.controller;

import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nlu.com.app.dto.response.ApiResponse;
import nlu.com.app.dto.response.DoctorSearchResponseDTO;
import nlu.com.app.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/doctor")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DoctorController {

  DoctorService doctorService;

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

//  @GetMapping("/search-acident/")
//  public ResponseEntity<ApiResponse<List<DoctorSearchResponseDTO>>> searchDoctorByAcident(
//      @RequestParam String keyword) {
//
//  }
}

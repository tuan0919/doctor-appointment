package nlu.com.app.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nlu.com.app.dto.response.ApiResponse;
import nlu.com.app.dto.response.DoctorSearchResponseDTO;
import nlu.com.app.service.DoctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true)
public class Tuan_DoctorController {

    DoctorService doctorService;

    @GetMapping("/doctor/list")
    public ApiResponse<List<DoctorSearchResponseDTO>> listDoctor() {
        return ApiResponse.<List<DoctorSearchResponseDTO>>builder()
                .result(doctorService.getListDoctor()).build();
    }
}
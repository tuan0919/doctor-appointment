package nlu.com.app.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nlu.com.app.dto.request.DoctorRegisterRequestDTO;
import nlu.com.app.dto.response.DoctorRegisterResponseDTO;
import nlu.com.app.service.DoctorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController {
    DoctorService doctorService;

    @PostMapping("/doctor/register")
    public DoctorRegisterResponseDTO registerDoctor(@Valid @RequestBody DoctorRegisterRequestDTO requestDTO) {
        return doctorService.registerDoctor(requestDTO);
    }
}

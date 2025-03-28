package nlu.com.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nlu.com.app.dto.response.DoctorCardDTO;
import nlu.com.app.service.DoctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true)
public class Tuan_DoctorController {
    DoctorService doctorService;

    @GetMapping("/doctor/list")
    public List<DoctorCardDTO> listDoctor() {
        return doctorService.listDoctors();
    }
}

package nlu.com.app.service;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nlu.com.app.dto.response.DoctorCardDTO;
import nlu.com.app.entity.Image;
import nlu.com.app.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true)
public class DoctorService {
    DoctorRepository doctorRepository;
    public List<DoctorCardDTO> listDoctors() {
        return doctorRepository.findAll().stream()
                .map(doctor -> DoctorCardDTO.builder()
                        .name(doctor.getFirstName() + doctor.getLastName())
                        .thumbnail(doctor.getImages().stream().findFirst().orElse(Image.builder().url("null").build()).getUrl())
                        .ratings(5.3f)
                        .visit(69)
                        .price(0)
                        .specialization(doctor.getSpecialization())
                        .hospital(doctor.getAddress()).build())
                .toList();
    }
}

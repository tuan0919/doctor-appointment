package nlu.com.app.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nlu.com.app.dto.response.DoctorCardDTO;
import nlu.com.app.dto.response.DoctorDetailsDTO;
import nlu.com.app.dto.response.DoctorSearchResponseDTO;
import nlu.com.app.entity.Accident;
import nlu.com.app.entity.Doctor;
import nlu.com.app.entity.Specialty;
import nlu.com.app.entity.Symptom;
import nlu.com.app.mapper.DoctorMapper;
import nlu.com.app.repository.AccidentRepository;
import nlu.com.app.repository.DoctorRepository;
import nlu.com.app.repository.SymptonRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DoctorService {
  SymptonRepository symptonRepository;
  DoctorRepository doctorRepository;
  AccidentRepository accidentRepository;
  DoctorMapper doctorMapper;

  public List<DoctorSearchResponseDTO> searchDoctorsBySymptoms(String symptomNames) {
    // Tìm tất cả triệu chứng khớp với danh sách nhập vào
    List<Symptom> symptoms = symptonRepository.findAllByNameContainingIgnoreCase(symptomNames);

    if (symptoms.isEmpty()) {
      return Collections.emptyList(); // Không có triệu chứng nào khớp
    }

    // Lấy danh sách tất cả chuyên khoa liên quan đến các triệu chứng tìm được
    Set<Specialty> specialties = symptoms.stream()
            .map(Symptom::getSpecialty)
            .collect(Collectors.toSet()); // Dùng Set để loại bỏ trùng lặp

    // Tìm tất cả bác sĩ thuộc các chuyên khoa đó
    List<Doctor> doctors = doctorRepository.findBySpecialtiesIn(specialties);

    return doctors.stream()
            .map(doctor -> DoctorSearchResponseDTO.builder()
                    .id(doctor.getId())
                    .thumbnail(doctor.getThumbnail())
                    .hospital(doctor.getHospital())
                    .price(doctor.getPrice())
                    .visits(doctor.getVisits())
                    .rating(doctor.getAvgRating())
                    .specialization(
                            doctor.getSpecialties().stream()
                                    .map(Specialty::getName)
                                    .collect(Collectors.joining(", ")) // Gộp các chuyên khoa thành chuỗi
                    )
                    .name(doctor.getName())
                    .build()
            )
            .collect(Collectors.toList());
  }
  public List<DoctorSearchResponseDTO> searchDoctorsByAccidents(String accident) {
    // Tìm tất cả tai nạn khớp với danh sách nhập vào
    List<Accident> accidents = accidentRepository.findAllByNameContainingIgnoreCase(accident);

    if (accidents.isEmpty()) {
      return Collections.emptyList(); // Không có tai nạn nào khớp
    }

    // Lấy danh sách tất cả chuyên khoa liên quan đến các tai nạn tìm được
    Set<Specialty> specialties = accidents.stream()
            .map(Accident::getSpecialty)
            .collect(Collectors.toSet());

    // Tìm tất cả bác sĩ thuộc các chuyên khoa đó
    List<Doctor> doctors = doctorRepository.findBySpecialtiesIn(specialties);

    return doctors.stream()
            .map(doctor -> DoctorSearchResponseDTO.builder()
                    .id(doctor.getId())
                    .thumbnail(doctor.getThumbnail())
                    .hospital(doctor.getHospital())
                    .visits(doctor.getVisits())
                    .price(doctor.getPrice())
                    .rating(doctor.getAvgRating())
                    .specialization(
                            doctor.getSpecialties().stream()
                                    .map(Specialty::getName)
                                    .collect(Collectors.joining(", ")) // Gộp các chuyên khoa thành chuỗi
                    )
                    .name(doctor.getName())
                    .build()
            )
            .collect(Collectors.toList());
  }

  public DoctorDetailsDTO getDoctorDetails(long id) {
    var doctor = doctorRepository.findById(id)
            .orElse(null);
    var doctorDetails = doctorMapper.toDoctorDetailsDTO(doctor);
    return doctorDetails;
  }

  public List<DoctorCardDTO> listDoctors() {
      return null;
  }


}

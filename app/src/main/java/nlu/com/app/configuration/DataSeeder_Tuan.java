package nlu.com.app.configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nlu.com.app.entity.Appointment;
import nlu.com.app.entity.Doctor;
import nlu.com.app.entity.Image;
import nlu.com.app.entity.Patient;
import nlu.com.app.entity.Role;
import nlu.com.app.enums.Accident;
import nlu.com.app.enums.Specialty;
import nlu.com.app.repository.AppointmentRepository;
import nlu.com.app.repository.DoctorRepository;
import nlu.com.app.repository.ImageRepository;
import nlu.com.app.repository.PatientRepository;
import nlu.com.app.repository.RoleRepository;
import nlu.com.app.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DataSeeder_Tuan {

  DoctorRepository doctorRepository;
  RoleRepository roleRepository;
  UserRepository userRepository;
  PatientRepository patientRepository;
  AppointmentRepository appointmentRepository;
  ImageRepository imageRepository;

  @Bean
  CommandLineRunner starterData() {
    return args -> {
      if (userRepository.count() > 0 || roleRepository.count() > 0) {
        System.out.println("✅ Dữ liệu đã tồn tại, không cần tạo lại.");
        return;
      }

      System.out.println("🚀 Đang tạo dữ liệu mẫu...");

      // Tạo Roles
      Role roleDoctor = new Role();
      roleDoctor.setUsers(new HashSet<>());
      Role rolePatient = new Role();
      rolePatient.setUsers(new HashSet<>());
      roleRepository.saveAll(List.of(roleDoctor, rolePatient));

      List<Doctor> doctors = new ArrayList<>();
//      List<Patient> patients = new ArrayList<>();
//      List<Appointment> appointments = new ArrayList<>();
//      List<Image> images = new ArrayList<>();
//      Random random = new Random();

      String[] imageUrls = {
              "https://images2.thanhnien.vn/thumb_w/686/528068263637045248/2024/3/7/41498385661961282804899348165590311304931596n-17098051418122006775403-0-286-2048-1822-crop-1709805739243640175866.jpg",
              "https://tamanhhospital.vn/wp-content/uploads/2020/12/duong-viet-bac-detail.png",
              "https://www.fvhospital.com/wp-content/uploads/2018/03/dr-vo-trieu-dat-2020.jpg",
              "https://benhvienhungvuong.vn/wp-content/uploads/2021/10/BS-Thu-PK-scaled-e1633133219260.jpg"
      };

      Doctor doctor1 = new Doctor();
      doctor1.setFirstName("Tùng");
      doctor1.setLastName("Nguyễn Văn");
      doctor1.setEmail("nguyenvantung@gmail.com");
      doctor1.setSpecialization(Specialty.PULMONOLOGY);
      doctor1.setAccident(Accident.DISLOCATION);
      doctor1.setExperience(10);
      doctor1.setQualification("PhD");
      doctor1.setAvgRating(5.0f);
      doctor1.setCreatedAt(LocalDateTime.now());
      doctor1.setImages(Set.of(Image.builder().url(imageUrls[0]).build()));
      doctors.add(doctor1);

      Doctor doctor2 = new Doctor();
      doctor2.setFirstName("Linh");
      doctor2.setLastName("Trần Thị");
      doctor2.setEmail("tranthilinh@gmail.com");
      doctor2.setSpecialization(Specialty.GASTROENTEROLOGY);
      doctor2.setAccident(Accident.FRACTURE);
      doctor2.setAvgRating(5.0f);
      doctor2.setExperience(8);
      doctor2.setQualification("MD");
      doctor2.setCreatedAt(LocalDateTime.now());
      doctor2.setImages(Set.of(Image.builder().url(imageUrls[1]).build()));
      doctors.add(doctor2);

      Doctor doctor3 = new Doctor();
      doctor3.setFirstName("Minh");
      doctor3.setLastName("Lê Hoàng");
      doctor3.setEmail("lehoangminh@gmail.com");
      doctor3.setSpecialization(Specialty.DERMATOLOGY);
      doctor3.setAccident(Accident.BURN);
      doctor3.setAvgRating(5.0f);
      doctor3.setExperience(12);
      doctor3.setQualification("PhD");
      doctor3.setCreatedAt(LocalDateTime.now());
      doctor3.setImages(Set.of(Image.builder().url(imageUrls[2]).build()));
      doctors.add(doctor3);

      Doctor doctor4 = new Doctor();
      doctor4.setFirstName("Hà");
      doctor4.setLastName("Phạm Văn");
      doctor4.setEmail("phamvanha@gmail.com");
      doctor4.setSpecialization(Specialty.NEUROLOGY);
      doctor4.setAccident(Accident.WOUND);
      doctor4.setExperience(15);
      doctor4.setAvgRating(5.0f);
      doctor4.setQualification("MD");
      doctor4.setImages(Set.of(Image.builder().url(imageUrls[3]).build()));
      doctor4.setCreatedAt(LocalDateTime.now());
      doctors.add(doctor4);

      Doctor doctor5 = new Doctor();
      doctor5.setFirstName("Lan");
      doctor5.setLastName("Nguyễn Thị");
      doctor5.setEmail("nguyenthilan@gmail.com");
      doctor5.setSpecialization(Specialty.INFECTIOUS_DISEASES);
      doctor5.setAvgRating(5.0f);
      doctor5.setAccident(Accident.DROWNING);
      doctor5.setExperience(9);
      doctor5.setQualification("MSc");
      doctor5.setImages(Set.of(Image.builder().url(imageUrls[2]).build()));
      doctor5.setCreatedAt(LocalDateTime.now());
      doctors.add(doctor5);

      Doctor doctor6 = new Doctor();
      doctor6.setFirstName("Dũng");
      doctor6.setLastName("Bùi Văn");
      doctor6.setEmail("buivandung@gmail.com");
      doctor6.setSpecialization(Specialty.GENERAL_PEDIATRICS);
      doctor6.setAvgRating(5.0f);
      doctor6.setAccident(Accident.FRACTURE);
      doctor6.setExperience(11);
      doctor6.setQualification("MD");
      doctor6.setImages(Set.of(Image.builder().url(imageUrls[1]).build()));
      doctor6.setCreatedAt(LocalDateTime.now());
      doctors.add(doctor6);

      Doctor doctor7 = new Doctor();
      doctor7.setFirstName("Phương");
      doctor7.setLastName("Đỗ Thị");
      doctor7.setEmail("dothiphuong@gmail.com");
      doctor7.setAvgRating(5.0f);
      doctor7.setSpecialization(Specialty.DERMATOLOGY);
      doctor7.setAccident(Accident.BURN);
      doctor7.setExperience(7);
      doctor7.setQualification("MSc");
      doctor7.setImages(Set.of(Image.builder().url(imageUrls[3]).build()));
      doctor7.setCreatedAt(LocalDateTime.now());
      doctors.add(doctor7);

      Doctor doctor8 = new Doctor();
      doctor8.setFirstName("Hải");
      doctor8.setLastName("Trương Công");
      doctor8.setEmail("truongconghai@gmail.com");
      doctor8.setSpecialization(Specialty.NEUROLOGY);
      doctor8.setAccident(Accident.DISLOCATION);
      doctor8.setAvgRating(5.0f);
      doctor8.setExperience(14);
      doctor8.setQualification("PhD");
      doctor8.setImages(Set.of(Image.builder().url(imageUrls[2]).build()));
      doctor8.setCreatedAt(LocalDateTime.now());
      doctors.add(doctor8);

      Doctor doctor9 = new Doctor();
      doctor9.setFirstName("Hạnh");
      doctor9.setLastName("Lý Thị");
      doctor9.setEmail("lythihanh@gmail.com");
      doctor9.setSpecialization(Specialty.GASTROENTEROLOGY);
      doctor9.setAccident(Accident.WOUND);
      doctor9.setAvgRating(5.0f);
      doctor9.setExperience(6);
      doctor9.setQualification("MD");
      doctor9.setImages(Set.of(Image.builder().url(imageUrls[1]).build()));
      doctor9.setCreatedAt(LocalDateTime.now());
      doctors.add(doctor9);

      Doctor doctor10 = new Doctor();
      doctor10.setFirstName("Tài");
      doctor10.setLastName("Vũ Hữu");
      doctor10.setEmail("vuhuutai@gmail.com");
      doctor10.setSpecialization(Specialty.PULMONOLOGY);
      doctor10.setAccident(Accident.DROWNING);
      doctor10.setAvgRating(5.0f);
      doctor10.setExperience(13);
      doctor10.setQualification("PhD");
      doctor10.setImages(Set.of(Image.builder().url(imageUrls[3]).build()));
      doctor10.setCreatedAt(LocalDateTime.now());
      doctors.add(doctor10);

      doctorRepository.saveAll(doctors);

//
//      // Tạo 20 bệnh nhân
//      for (int i = 1; i <= 20; i++) {
//        Patient patient = new Patient();
//        patient.setFirstName("Patient" + i);
//        patient.setLastName("Lastname" + i);
//        patient.setEmail("patient" + i + "@example.com");
//        patient.setDateOfBirth(LocalDate.of(1980 + random.nextInt(30), random.nextInt(12) + 1,
//            random.nextInt(28) + 1));
//        patient.setGender(i % 2 == 0 ? "Male" : "Female");
//        patient.setMedicalHistory("Medical history " + i);
//        patient.setCreatedAt(LocalDateTime.now());
////        patient.setRoles(Set.of(rolePatient));
//        patients.add(patient);
//      }
//      patientRepository.saveAll(patients);

//      // Tạo 20 cuộc hẹn ngẫu nhiên giữa bác sĩ và bệnh nhân
//      for (int i = 0; i < 20; i++) {
//        Appointment appointment = new Appointment();
//        appointment.setDoctor(doctors.get(random.nextInt(doctors.size())));
//        appointment.setPatient(patients.get(random.nextInt(patients.size())));
//        appointments.add(appointment);
//      }
//      appointmentRepository.saveAll(appointments);
//
//      // Danh sách hình ảnh mẫu

//
//      System.out.println("✅ Dữ liệu mẫu đã được tạo thành công!");
    };
  }
}

package nlu.com.app.configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import nlu.com.app.entity.Appointment;
import nlu.com.app.entity.Doctor;
import nlu.com.app.entity.Image;
import nlu.com.app.entity.Patient;
import nlu.com.app.entity.Role;
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
public class DataSeeder {

  @Bean
  CommandLineRunner initDatabase(UserRepository userRepo, RoleRepository roleRepo,
      DoctorRepository doctorRepo, PatientRepository patientRepo,
      AppointmentRepository appointmentRepo, ImageRepository imageRepo) {
    return args -> {
      if (userRepo.count() > 0 || roleRepo.count() > 0) {
        System.out.println("✅ Dữ liệu đã tồn tại, không cần tạo lại.");
        return;
      }

      System.out.println("🚀 Đang tạo dữ liệu mẫu...");

      // Tạo Roles
//      Role roleDoctor = new Role();
//      roleDoctor.setUsers(new HashSet<>());
//      Role rolePatient = new Role();
//      rolePatient.setUsers(new HashSet<>());
//      roleRepo.saveAll(List.of(roleDoctor, rolePatient));

      List<Doctor> doctors = new ArrayList<>();
      List<Patient> patients = new ArrayList<>();
      List<Appointment> appointments = new ArrayList<>();
      List<Image> images = new ArrayList<>();
      Random random = new Random();

      // Tạo 20 bác sĩ
      for (int i = 1; i <= 20; i++) {
        Doctor doctor = new Doctor();
        doctor.setFirstName("Doctor" + i);
        doctor.setLastName("Lastname" + i);
        doctor.setEmail("doctor" + i + "@example.com");
        doctor.setSpecialization("Specialization " + (i % 5 + 1));
        doctor.setExperience(random.nextInt(20) + 5);
        doctor.setQualification("MD / PhD " + i);
        doctor.setCreatedAt(LocalDateTime.now());
//        doctor.setRoles(Set.of(roleDoctor));
        doctors.add(doctor);
      }
      doctorRepo.saveAll(doctors);

      // Tạo 20 bệnh nhân
      for (int i = 1; i <= 20; i++) {
        Patient patient = new Patient();
        patient.setFirstName("Patient" + i);
        patient.setLastName("Lastname" + i);
        patient.setEmail("patient" + i + "@example.com");
        patient.setDateOfBirth(LocalDate.of(1980 + random.nextInt(30), random.nextInt(12) + 1,
            random.nextInt(28) + 1));
        patient.setGender(i % 2 == 0 ? "Male" : "Female");
        patient.setMedicalHistory("Medical history " + i);
        patient.setCreatedAt(LocalDateTime.now());
//        patient.setRoles(Set.of(rolePatient));
        patients.add(patient);
      }
      patientRepo.saveAll(patients);

      // Tạo 20 cuộc hẹn ngẫu nhiên giữa bác sĩ và bệnh nhân
      for (int i = 0; i < 20; i++) {
        Appointment appointment = new Appointment();
        appointment.setDoctor(doctors.get(random.nextInt(doctors.size())));
        appointment.setPatient(patients.get(random.nextInt(patients.size())));
        appointments.add(appointment);
      }
      appointmentRepo.saveAll(appointments);

      // Danh sách hình ảnh mẫu
      String[] imageUrls = {
          "https://images2.thanhnien.vn/thumb_w/686/528068263637045248/2024/3/7/41498385661961282804899348165590311304931596n-17098051418122006775403-0-286-2048-1822-crop-1709805739243640175866.jpg",
          "https://tamanhhospital.vn/wp-content/uploads/2020/12/duong-viet-bac-detail.png",
          "https://www.fvhospital.com/wp-content/uploads/2018/03/dr-vo-trieu-dat-2020.jpg",
          "https://benhvienhungvuong.vn/wp-content/uploads/2021/10/BS-Thu-PK-scaled-e1633133219260.jpg"
      };

      // Tạo 20 hình ảnh ngẫu nhiên
      for (int i = 0; i < 20; i++) {
        Image image = new Image();
        image.setUser(patients.get(random.nextInt(patients.size())));
        image.setUrl(imageUrls[i % imageUrls.length]); // Chọn hình ảnh từ danh sách
        image.setType("profile");
        image.setCreatedAt(LocalDateTime.now());
        images.add(image);
      }
      imageRepo.saveAll(images);

      System.out.println("✅ Dữ liệu mẫu đã được tạo thành công!");
    };
  }
}

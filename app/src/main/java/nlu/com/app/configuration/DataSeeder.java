package nlu.com.app.configuration;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import nlu.com.app.entity.Accident;
import nlu.com.app.entity.Doctor;
import nlu.com.app.entity.Specialty;
import nlu.com.app.entity.Symptom;
import nlu.com.app.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DataSeeder {
    DoctorRepository doctorRepository;
    RoleRepository roleRepository;
    UserRepository userRepository;
    PatientRepository patientRepository;
    AppointmentRepository appointmentRepository;
    SpecialityRepository specialityRepository;
    SymptonRepository symptonRepository;
    AccidentRepository accidentRepository;

    @Bean
    CommandLineRunner runner() {
        return args -> {
            // chuyen khoa
            var specialities = List.of(
                    Specialty.builder().name("Chuyên khoa phổi").build(),
                    Specialty.builder().name("Chuyên khoa tiêu hóa").build(),
                    Specialty.builder().name("Chuyên khoa da liễu").build(),
                    Specialty.builder().name("Chuyên khoa thần kinh").build(),
                    Specialty.builder().name("Bệnh truyền nhiễm").build(),
                    Specialty.builder().name("Nhi khoa tổng quát").build(),
                    Specialty.builder().name("Chuyên khoa tim mạch").build(),
                    Specialty.builder().name("Chuyên khoa tiết niệu").build(),
                    Specialty.builder().name("Chuyên khoa nội tiết").build(),
                    Specialty.builder().name("Chuyên khoa cơ xương khớp").build(),
                    Specialty.builder().name("Chuyên khoa tai mũi họng").build(),
                    Specialty.builder().name("Chuyên khoa mắt").build(),
                    Specialty.builder().name("Chuyên khoa sản phụ khoa").build(),
                    Specialty.builder().name("Chuyên khoa huyết học").build(),
                    Specialty.builder().name("Chuyên khoa ung bướu").build(),
                    Specialty.builder().name("Chuyên khoa nội tổng quát").build(),
                    Specialty.builder().name("Chuyên khoa hồi sức cấp cứu").build()
            );

            var doctors = List.of(
                    Doctor.builder()
                            .name("Lâm Việt Trung")
                            .bio("Phó Giáo sư, Tiến sĩ, Bác sĩ Lâm Việt Trung đã có hơn 20 năm kinh nghiệm trong lĩnh vực Tiêu hóa.")
                            .price(100000)
                            .experience(20)
                            .education("Tiến sĩ")
                            .avgRating(4.9f)
                            .thumbnail("https://images.unsplash.com/photo-1537368910025-700350fe46c7")
                            .visits(341)
                            .hospital("Bệnh viện Chợ Rẫy")
                            .specialties(List.of(specialities.get(1)))
                            .build(),

                    Doctor.builder()
                            .name("Nguyễn Văn A")
                            .bio("Tiến sĩ, Bác sĩ Nguyễn Văn A, chuyên gia về hô hấp, với hơn 15 năm kinh nghiệm.")
                            .price(120000)
                            .experience(15)
                            .education("Tiến sĩ")
                            .avgRating(4.8f)
                            .thumbnail("https://images.unsplash.com/photo-1576091160399-112ba8d25d1d")
                            .visits(280)
                            .hospital("Bệnh viện Đại học Y Dược TP.HCM")
                            .specialties(List.of(specialities.get(0)))
                            .build(),

                    Doctor.builder()
                            .name("Lê Thị B")
                            .bio("Thạc sĩ, Bác sĩ Lê Thị B, chuyên khoa da liễu với hơn 10 năm kinh nghiệm.")
                            .price(90000)
                            .experience(10)
                            .education("Thạc sĩ")
                            .avgRating(4.7f)
                            .thumbnail("https://images.unsplash.com/photo-1527613426441-4da17471b66d")
                            .visits(250)
                            .hospital("Bệnh viện Da Liễu")
                            .specialties(List.of(specialities.get(2)))
                            .build(),

                    Doctor.builder()
                            .name("Trần Văn C")
                            .bio("Bác sĩ Trần Văn C, chuyên khoa thần kinh, nhiều năm nghiên cứu và giảng dạy tại ĐH Y Dược.")
                            .price(110000)
                            .experience(18)
                            .education("Bác sĩ chuyên khoa II")
                            .avgRating(4.6f)
                            .thumbnail("https://images.unsplash.com/photo-1603398938378-48ab2b4a08f0")
                            .visits(310)
                            .hospital("Bệnh viện Nhân Dân 115")
                            .specialties(List.of(specialities.get(3)))
                            .build(),

                    Doctor.builder()
                            .name("Phạm Văn D")
                            .bio("Giáo sư, Tiến sĩ Phạm Văn D, chuyên khoa bệnh truyền nhiễm, đã từng công tác tại WHO.")
                            .price(150000)
                            .experience(25)
                            .education("Giáo sư")
                            .avgRating(4.9f)
                            .thumbnail("https://images.unsplash.com/photo-1584467735871-768b6df7c63b")
                            .visits(500)
                            .hospital("Viện Pasteur TP.HCM")
                            .specialties(List.of(specialities.get(4)))
                            .build(),

                    Doctor.builder()
                            .name("Nguyễn Thị E")
                            .bio("Thạc sĩ, Bác sĩ Nguyễn Thị E, chuyên khoa nhi với hơn 12 năm kinh nghiệm điều trị trẻ em.")
                            .price(95000)
                            .experience(12)
                            .education("Thạc sĩ")
                            .avgRating(4.8f)
                            .thumbnail("https://images.unsplash.com/photo-1629904853893-a38d1ec99403")
                            .visits(270)
                            .hospital("Bệnh viện Nhi Đồng 1")
                            .specialties(List.of(specialities.get(5)))
                            .build(),

                    Doctor.builder()
                            .name("Đặng Minh F")
                            .bio("Bác sĩ Đặng Minh F, chuyên khoa tim mạch, đã thực hiện nhiều ca phẫu thuật tim thành công.")
                            .price(130000)
                            .experience(22)
                            .education("Tiến sĩ")
                            .avgRating(4.8f)
                            .thumbnail("https://images.unsplash.com/photo-1561207169-2c3f3222b247")
                            .visits(400)
                            .hospital("Viện Tim TP.HCM")
                            .specialties(List.of(specialities.get(6)))
                            .build(),

                    Doctor.builder()
                            .name("Hồ Văn G")
                            .bio("Tiến sĩ, Bác sĩ Hồ Văn G, chuyên khoa tiết niệu, chuyên gia phẫu thuật nội soi hiện đại.")
                            .price(110000)
                            .experience(17)
                            .education("Tiến sĩ")
                            .avgRating(4.7f)
                            .thumbnail("https://images.unsplash.com/photo-1579684385127-1ef15d508118")
                            .visits(320)
                            .hospital("Bệnh viện Bình Dân")
                            .specialties(List.of(specialities.get(7)))
                            .build(),

                    Doctor.builder()
                            .name("Trịnh Ngọc H")
                            .bio("Bác sĩ chuyên khoa I Trịnh Ngọc H, chuyên khoa nội tiết, có nhiều công trình nghiên cứu về tiểu đường.")
                            .price(100000)
                            .experience(14)
                            .education("Bác sĩ chuyên khoa I")
                            .avgRating(4.6f)
                            .thumbnail("https://images.unsplash.com/photo-1511174511562-5f7f18b874f8")
                            .visits(290)
                            .hospital("Bệnh viện Nội Tiết Trung Ương")
                            .specialties(List.of(specialities.get(8)))
                            .build(),

                    Doctor.builder()
                            .name("Nguyễn Văn I")
                            .bio("Giáo sư, Tiến sĩ Nguyễn Văn I, chuyên khoa cơ xương khớp, chuyên điều trị các bệnh thoái hóa khớp.")
                            .price(140000)
                            .experience(30)
                            .education("Giáo sư")
                            .avgRating(4.9f)
                            .thumbnail("https://images.unsplash.com/photo-1629904854317-6af1f040b34c")
                            .visits(600)
                            .hospital("Bệnh viện Chấn Thương Chỉnh Hình")
                            .specialties(List.of(specialities.get(9)))
                            .build()
            );
            var accidents = List.of(
                    Accident.builder().name("Gãy tay").specialty(specialities.get(9)).build(), // Cơ xương khớp
                    Accident.builder().name("Gãy chân").specialty(specialities.get(9)).build(), // Cơ xương khớp
                    Accident.builder().name("Chấn thương sọ não").specialty(specialities.get(3)).build(), // Thần kinh
                    Accident.builder().name("Đứt dây chằng gối").specialty(specialities.get(9)).build(), // Cơ xương khớp
                    Accident.builder().name("Trật khớp vai").specialty(specialities.get(9)).build(), // Cơ xương khớp
                    Accident.builder().name("Bỏng nước sôi").specialty(specialities.get(2)).build(), // Da liễu
                    Accident.builder().name("Té xe gây chấn thương đầu gối").specialty(specialities.get(9)).build(), // Cơ xương khớp
                    Accident.builder().name("Tai nạn giao thông gây chấn thương vùng bụng").specialty(specialities.get(1)).build(), // Tiêu hóa
                    Accident.builder().name("Đuối nước gây tổn thương phổi").specialty(specialities.get(0)).build(), // Hô hấp
                    Accident.builder().name("Gãy xương đòn").specialty(specialities.get(9)).build(), // Cơ xương khớp
                    Accident.builder().name("Chấn thương cột sống").specialty(specialities.get(9)).build(), // Cơ xương khớp
                    Accident.builder().name("Ngộ độc thực phẩm").specialty(specialities.get(1)).build(), // Tiêu hóa
                    Accident.builder().name("Cắn bởi động vật hoang dã").specialty(specialities.get(4)).build(), // Bệnh truyền nhiễm
                    Accident.builder().name("Phỏng hóa chất").specialty(specialities.get(2)).build(), // Da liễu
                    Accident.builder().name("Sét đánh gây bỏng điện").specialty(specialities.get(2)).build(), // Da liễu
                    Accident.builder().name("Bị thương do dao cắt sâu").specialty(specialities.get(2)).build(), // Da liễu
                    Accident.builder().name("Chấn thương do tai nạn lao động").specialty(specialities.get(9)).build(), // Cơ xương khớp
                    Accident.builder().name("Ngạt khói do hỏa hoạn").specialty(specialities.get(0)).build(), // Hô hấp
                    Accident.builder().name("Sốc phản vệ do côn trùng cắn").specialty(specialities.get(4)).build(), // Bệnh truyền nhiễm
                    Accident.builder().name("Chấn thương tim do va đập mạnh").specialty(specialities.get(6)).build() // Tim mạch
            );
            var symptoms = List.of(
                    Symptom.builder().name("Ho kéo dài").specialty(specialities.get(0)).build(), // Hô hấp
                    Symptom.builder().name("Khó thở khi vận động").specialty(specialities.get(0)).build(), // Hô hấp
                    Symptom.builder().name("Đau dạ dày").specialty(specialities.get(1)).build(), // Tiêu hóa
                    Symptom.builder().name("Táo bón kéo dài").specialty(specialities.get(1)).build(), // Tiêu hóa
                    Symptom.builder().name("Phát ban, nổi mề đay").specialty(specialities.get(2)).build(), // Da liễu
                    Symptom.builder().name("Ngứa da không rõ nguyên nhân").specialty(specialities.get(2)).build(), // Da liễu
                    Symptom.builder().name("Đau đầu thường xuyên").specialty(specialities.get(3)).build(), // Thần kinh
                    Symptom.builder().name("Chóng mặt, mất thăng bằng").specialty(specialities.get(3)).build(), // Thần kinh
                    Symptom.builder().name("Sốt cao không rõ nguyên nhân").specialty(specialities.get(4)).build(), // Bệnh truyền nhiễm
                    Symptom.builder().name("Mệt mỏi kéo dài").specialty(specialities.get(4)).build(), // Bệnh truyền nhiễm
                    Symptom.builder().name("Sưng đau khớp gối").specialty(specialities.get(9)).build(), // Cơ xương khớp
                    Symptom.builder().name("Cứng khớp buổi sáng").specialty(specialities.get(9)).build(), // Cơ xương khớp
                    Symptom.builder().name("Đau tức ngực").specialty(specialities.get(6)).build(), // Tim mạch
                    Symptom.builder().name("Tim đập nhanh, hồi hộp").specialty(specialities.get(6)).build(), // Tim mạch
                    Symptom.builder().name("Tiểu buốt, tiểu rắt").specialty(specialities.get(7)).build(), // Tiết niệu
                    Symptom.builder().name("Tiểu ra máu").specialty(specialities.get(7)).build(), // Tiết niệu
                    Symptom.builder().name("Tăng cân không kiểm soát").specialty(specialities.get(8)).build(), // Nội tiết
                    Symptom.builder().name("Rụng tóc bất thường").specialty(specialities.get(8)).build(), // Nội tiết
                    Symptom.builder().name("Suy giảm trí nhớ").specialty(specialities.get(3)).build(), // Thần kinh
                    Symptom.builder().name("Khó ngủ, mất ngủ kéo dài").specialty(specialities.get(3)).build() // Thần kinh
            );
            specialityRepository.saveAll(specialities);
            doctorRepository.saveAll(doctors);
            symptonRepository.saveAll(symptoms);
            accidentRepository.saveAll(accidents);
        };
    }
}

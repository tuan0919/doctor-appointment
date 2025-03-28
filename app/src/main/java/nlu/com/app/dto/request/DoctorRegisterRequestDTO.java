package nlu.com.app.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level =  AccessLevel.PRIVATE)
public class DoctorRegisterRequestDTO {
    @NotBlank(message = "Tên bác sĩ không được bỏ trống")
    String name;

    @NotBlank(message = "Email không được bỏ trống")
    @Email(message = "Email không hợp lệ")
    String email;

    @NotBlank(message = "Số điện thoại không được bỏ trống")
    String phone;

    @NotBlank(message = "Mật khẩu không được bỏ trống")
    String password;

    String confirmPassword;

    @NotBlank(message = "Bệnh viện không được bỏ trống")
    String hospital;

    @NotBlank(message = "Địa chỉ không được bỏ trống")
    String address;
}

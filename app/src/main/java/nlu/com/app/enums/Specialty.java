package nlu.com.app.enums;

import java.util.Arrays;
import java.util.List;

public enum Specialty {
  PULMONOLOGY("Chuyên khoa phổi", Arrays.asList("Ho", "Khó thở", "Hen suyễn", "Viêm phổi")),
  GASTROENTEROLOGY("Chuyên khoa tiêu hóa", Arrays.asList("Tiêu chảy", "Đau bụng", "Táo bón", "Nôn ói")),
  DERMATOLOGY("Chuyên khoa da liễu", Arrays.asList("Phát ban", "Dị ứng", "Nổi mẩn đỏ", "Eczema")),
  NEUROLOGY("Chuyên khoa thần kinh", Arrays.asList("Động kinh", "Đau đầu", "Mất ngủ", "Rối loạn vận động")),
  INFECTIOUS_DISEASES("Bệnh truyền nhiễm", Arrays.asList("Sốt", "Nhiễm trùng", "Sốt xuất huyết", "Viêm não")),
  GENERAL_PEDIATRICS("Nhi khoa tổng quát", Arrays.asList("Cảm lạnh", "Sốt", "Biếng ăn", "Sụt cân"));

  private final String description;
  private final List<String> symptoms;

  Specialty(String description, List<String> symptoms) {
    this.description = description;
    this.symptoms = symptoms;
  }

  public String getDescription() {
    return description;
  }

  public List<String> getSymptoms() {
    return symptoms;
  }
}

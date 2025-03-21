package nlu.com.app.enums;

import java.util.Arrays;
import java.util.List;

public enum Accident {
  FRACTURE("Gãy xương", Arrays.asList("Gãy tay", "Gãy chân", "Gãy xương đòn"), "Bác sĩ chỉnh hình"),
  DISLOCATION("Trật khớp", Arrays.asList("Trật khớp vai", "Trật đầu gối", "Trật cổ tay"), "Bác sĩ chỉnh hình"),
  BURN("Bỏng", Arrays.asList("Bỏng nước sôi", "Bỏng dầu ăn", "Bỏng hóa chất"), "Bác sĩ da liễu"),
  WOUND("Vết thương", Arrays.asList("Vết cắt sâu", "Đứt tay", "Bị đâm"), "Bác sĩ ngoại khoa"),
  DROWNING("Ngạt nước", Arrays.asList("Đuối nước", "Sặc nước"), "Bác sĩ cấp cứu");

  private final String name;
  private final List<String> keywords;
  private final String treatmentSpecialty;

  Accident(String name, List<String> keywords, String treatmentSpecialty) {
    this.name = name;
    this.keywords = keywords;
    this.treatmentSpecialty = treatmentSpecialty;
  }

  public String getName() {
    return name;
  }

  public List<String> getKeywords() {
    return keywords;
  }

  public String getTreatmentSpecialty() {
    return treatmentSpecialty;
  }

  public static String findSpecialtyByAccident(String keyword) {
    for (Accident accident : values()) {
      if (accident.keywords.contains(keyword)) {
        return accident.treatmentSpecialty;
      }
    }
    return "Không tìm thấy bác sĩ chuyên trị phù hợp.";
  }
}

package nlu.com.app.controller;

import lombok.RequiredArgsConstructor;
import nlu.com.app.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/doctor")
@RequiredArgsConstructor
public class DoctorController {

  @Autowired
  DoctorService doctorService;
}

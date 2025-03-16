package nlu.com.app.controller;

import lombok.RequiredArgsConstructor;
import nlu.com.app.service.ExampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/example")
@RequiredArgsConstructor
public class ExampleController {
    ExampleService service;

    @GetMapping("/hi")
    public String greet() {
        return service.greet();
    }
}

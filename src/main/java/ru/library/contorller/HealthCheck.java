package ru.library.contorller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HealthCheck {

    @GetMapping("/healthcheck")
    public String say() {
        return "200 OK";
    }

}

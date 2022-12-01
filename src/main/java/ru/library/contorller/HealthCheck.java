package ru.library.contorller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HealthCheck {

    @GetMapping("/")
    public HttpStatus say() {
        return HttpStatus.OK;
    }

}

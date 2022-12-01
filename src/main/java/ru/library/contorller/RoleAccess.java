package ru.library.contorller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleAccess {

    @GetMapping("/admin")
    public HttpStatus gerAccessAdmin(){
        return HttpStatus.OK;
    }
    @GetMapping("/user")
    public HttpStatus gerAccessUser(){
         return HttpStatus.OK;
    }


}

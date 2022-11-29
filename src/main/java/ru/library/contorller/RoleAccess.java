package ru.library.contorller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleAccess {

    @GetMapping("/admin")
    public String gerAccessAdmin(){
        return "Hello admin!";
    }
    @GetMapping("/user")
    public String gerAccessUser(){
        return "Hello user!";
    }


}

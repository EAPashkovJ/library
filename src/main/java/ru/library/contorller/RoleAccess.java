package ru.library.contorller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RoleAccess {


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public HttpStatus gerAccessAdmin(){
        return HttpStatus.OK;
    }
    @GetMapping("/user")
    public HttpStatus gerAccessUser(){
         return HttpStatus.OK;
    }


}

package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @GetMapping("/current-user")
    public String getLoggedUser(Principal principal){
        return principal.getName();
    }

    @GetMapping("/test")
    public String test(){
        String s =  "IN ADMIN PAGE";
        return s;
    }
}

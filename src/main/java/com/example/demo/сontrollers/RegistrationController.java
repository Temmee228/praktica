package com.example.demo.сontrollers;

import ch.qos.logback.core.model.Model;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserServicelmpl;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {
    private final UserServicelmpl userServicelmpl;
    public RegistrationController(UserServicelmpl userServicelmpl) {
        this.userServicelmpl = userServicelmpl;
    }


    @PostMapping("/registration")
    public UserModel registerUser(@RequestParam String username,@RequestParam String password) {

       return userServicelmpl.registerUser(username,password);
    }



}

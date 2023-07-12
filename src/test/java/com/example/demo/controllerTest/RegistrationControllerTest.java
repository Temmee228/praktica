/*
package com.example.demo.controllerTest;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserServicelmpl;
import com.example.demo.сontrollers.RegistrationController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@WebMvcTest(RegistrationController.class)
public class RegistrationControllerTest {

    @Autowired
    private RegistrationController registrationController;

    @MockBean
    private UserServicelmpl userServicelmpl;
    @Test
    public void registerUser() {

        UserModel user1 = new UserModel();
    String username = "testUsername";
    String password = "123";


    when(userServicelmpl.registerUser(any(String.class),any(String.class))).thenReturn(user1);

    UserModel result = registrationController.registerUser(username,password);

    assertEquals(user1, result);
    }


}
*/

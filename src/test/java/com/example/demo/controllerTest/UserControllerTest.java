/*
package com.example.demo.controllerTest;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserServicelmpl;
import com.example.demo.сontrollers.UserController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class UserControllerTest {

    private UserController userController;

    @Mock
    private UserServicelmpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        userController = new UserController(userService);
    }

    @Test
    void testAll() {

        List<UserModel> users = new ArrayList<>();
        UserModel user1 = new UserModel();
        user1.setId(1L);
        user1.setName("John");
        users.add(user1);

        UserModel user2 = new UserModel();
        user2.setId(2L);
        user2.setName("Jane");
        users.add(user2);

        Page<UserModel> expectedPage = new PageImpl<>(users);
        when(userService.getAll(any(Pageable.class))).thenReturn(expectedPage);


        Page<UserModel> result = userController.all(0, 10, "id");


        assertEquals(expectedPage, result);
    }

    @Test
    void testDelete() {

        Long id = 1L;


        String result = userController.del(id);


        assertEquals("Успешно", result);
    }

    @Test
    void testAdd() {

        UserModel userModel = new UserModel();
        userModel.setId(1L);
        userModel.setName("John");
        when(userService.save(any(UserModel.class))).thenReturn(userModel);


        UserModel result = userController.add(userModel);

        assertEquals(userModel, result);
    }

    @Test
    void testUpdate() {

        Long id = 1L;
        UserModel userModel = new UserModel();
        userModel.setId(1L);
        userModel.setName("John");
        when(userService.update(any(UserModel.class), anyLong())).thenReturn(userModel);


        UserModel result = userController.up(id, userModel);


        assertEquals(userModel, result);
    }




}*/

package com.example.demo.Controller;

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
import org.springframework.data.domain.Sort;

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
        // Arrange
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

        // Act
        Page<UserModel> result = userController.all(0, 10, "id");

        // Assert
        assertEquals(expectedPage, result);
    }

    @Test
    void testDelete() {
        // Arrange
        Long id = 1L;

        // Act
        String result = userController.del(id);

        // Assert
        assertEquals("Успешно", result);
    }

    @Test
    void testAdd() {
        // Arrange
        UserModel userModel = new UserModel();
        userModel.setId(1L);
        userModel.setName("John");
        when(userService.save(any(UserModel.class))).thenReturn(userModel);

        // Act
        UserModel result = userController.add(userModel);

        // Assert
        assertEquals(userModel, result);
    }

    @Test
    void testUpdate() {
        // Arrange
        Long id = 1L;
        UserModel userModel = new UserModel();
        userModel.setId(1L);
        userModel.setName("John");
        when(userService.update(any(UserModel.class), anyLong())).thenReturn(userModel);

        // Act
        UserModel result = userController.up(id, userModel);

        // Assert
        assertEquals(userModel, result);
    }
}
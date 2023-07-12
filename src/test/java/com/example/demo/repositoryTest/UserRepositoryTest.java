package com.example.demo.repositoryTest;

import com.example.demo.model.UserModel;

import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;

import static junit.framework.TestCase.*;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

/*
    @Test
    public void findByUsername() {
        String username = "testUsername";
        UserModel user = new UserModel();
        user.setUsername(username);
        userRepository.save(user);

        UserModel result = userRepository.findByUsername(username);

        assertNotNull(result);
        assertEquals(username, result.getUsername());
    }

    @Test
    public void testFindByNameContaining() {

        String name = "John";
        UserModel user1 = new UserModel();
        user1.setName("John Doe");
        userRepository.save(user1);

        UserModel user2 = new UserModel();
        user2.setName("John Smith");
        userRepository.save(user2);


        List<UserModel> result = userRepository.findByNameContaining(name);


        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(user1, result.get(0));
        assertEquals(user2, result.get(1));
    }

    @Test
    public void testFindByGrade() {

        String grade = "1A";
        UserModel user1 = new UserModel();
        user1.setGrade("1A");
        userRepository.save(user1);

        UserModel user2 = new UserModel();
        user2.setGrade("1B");
        userRepository.save(user2);


        List<UserModel> result = userRepository.findByGrade(grade);


        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(user1, result.get(0));
    }

    @Test
    public void testFindByCity() {

        String city = "New York";
        UserModel user1 = new UserModel();
        user1.setCity("New York");
        userRepository.save(user1);

        UserModel user2 = new UserModel();
        user2.setCity("Los Angeles");
        userRepository.save(user2);

        List<UserModel> result = userRepository.findByCity(city);


        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(user1, result.get(0));
    }

*/
}

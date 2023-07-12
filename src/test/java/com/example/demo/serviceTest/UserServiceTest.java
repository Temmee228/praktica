/*

package com.example.demo.serviceTest;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserServicelmpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    private UserServicelmpl userService;

    private static UserModel testUser;

    @BeforeClass
    public static void prepareTestData() {
        testUser = new UserModel();
                testUser.setId(1);
                testUser.setName("ТестКирилл");
                testUser.setSchool("11");
                testUser.setCity("ТестЯрослаль");
    }

    @Before
    public void init() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userService = new UserServicelmpl(bCryptPasswordEncoder, userRepository);
    }

    @Test
    public void updateTest() {
        when(userRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(testUser));
        when(userRepository.save(any(UserModel.class))).thenReturn((testUser));
        UserModel userModelForUpdate =  new UserModel();
            testUser.setName("Кирилл");
            testUser.setSchool("88");
            testUser.setCity("Ярослаль");

        UserModel resultUser = userService.update(userModelForUpdate,1L );

        assertNotNull(resultUser);
        assertSame(resultUser.getId(),testUser.getId());
        assertEquals(resultUser.getName(),(userModelForUpdate.getName()));
        assertEquals(resultUser.getCity(),(userModelForUpdate.getCity()));

    }
}
*/

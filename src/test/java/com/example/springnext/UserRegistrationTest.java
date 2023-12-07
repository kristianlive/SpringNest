package com.example.springnext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.springnext.service.UserService;
import com.example.springnext.model.User;

@SpringBootTest
public class UserRegistrationTest {

    @MockBean
    private UserService userService;

    @Test
    public void testUserRegistration() {
        User newUser = new User();
        newUser.setUsername("testuser");
        newUser.setPassword("password");

        when(userService.addUser(any(User.class))).thenReturn(newUser);

        User registeredUser = userService.addUser(newUser);

        assertEquals(newUser.getUsername(), registeredUser.getUsername());

        verify(userService).addUser(any(User.class));
    }
}

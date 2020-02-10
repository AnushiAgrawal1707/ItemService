package com.mykart.testservices;


import com.mykart.model.User;
import com.mykart.repository.user.UserRepository;
import com.mykart.service.user.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserTestServices {


    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;




    @Test
    public void saveUserTest()
    {
        User user=mock(User.class);
        when(userRepository.save(user)).thenReturn(user);
        userService.saveUser(user);
        verify(userRepository,times(1)).save(user);
    }
   @Test
    public void updateUserTest()
    {
        User user=mock(User.class);
        when(userRepository.save(user)).thenReturn(user);
        userService.updateUser(user);
        verify(userRepository,times(1)).save(user);
    }
    @Test
    public void deleteUserTest()
    {
        User user=mock(User.class);
        userService.deleteUser(user);
        verify(userRepository,times(1)).delete(user);
    }
}

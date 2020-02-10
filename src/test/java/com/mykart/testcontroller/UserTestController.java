package com.mykart.testcontroller;


import com.mykart.controller.user.UserController;
import com.mykart.exception.ResourceNotFound;
import com.mykart.model.Orders;
import com.mykart.model.User;
import com.mykart.service.user.UserService;
import io.swagger.annotations.ApiParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserTestController {

  @Mock UserService userService;

  @InjectMocks UserController userController;



  @Test
  public void saveUserTest() throws ResourceNotFound {

    User user = mock(User.class);
    when(userService.saveUser(user)).thenReturn(user);
    userController.saveUser(user);
    verify(userService, times(1)).saveUser(user);
  }



  @Test
  public void updateUserTest() throws ResourceNotFound {

    User user = mock(User.class);
    when(userService.getUserById(101)).thenReturn(user);
    when(userService.updateUser(user)).thenReturn(user);
    userController.updateUser(101, user);
    verify(userService, times(1)).updateUser(user);
  }
   @Test
   public void deleteUserTest() throws ResourceNotFound {
      User user = mock(User.class);
      when(userService.getUserById(101)).thenReturn(user);
      userService.deleteUser(user);
      userController.deleteUser(101);
      verify(userService,times(2)).deleteUser(user);

  }



}


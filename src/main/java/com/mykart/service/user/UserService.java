package com.mykart.service.user;

import com.mykart.model.User;

import java.util.List;

public interface UserService {
    public Iterable<User> getAllUsers(int page, int size);
    public User getUserById(int userId);
    public User saveUser(User user);
    public void deleteUser(User user);
    public User updateUser(User user);
}

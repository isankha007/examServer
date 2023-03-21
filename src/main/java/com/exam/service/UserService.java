package com.exam.service;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.payload.UserDto;

import java.util.Set;

public interface UserService {
    //creating user
    public User createUser(User user);
    public User getUser(String userName);

    public void deleteUser(Long id);

    UserDto registerNewUser(UserDto userDto);

}

package com.exam.service;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user) {
        User byUserName = this.userRepository.findByUserName(user.getUserName());
        if(byUserName!=null){
            System.out.println("User is already there");
            throw new RuntimeException("User Already Present");
        }else {
//            for(Role role:roles){
//                roleRepository.save(role);
//            }
           // user.getRoles().addAll(roles);
            byUserName=userRepository.save(user);
        }
        return byUserName;
    }
}

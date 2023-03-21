package com.exam.service;

import com.exam.config.AppConstants;
import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.exception.ResourceNotFoundException;
import com.exam.payload.UserDto;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

   @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {
        User byUserName = this.userRepository.findByEmail(user.getEmail())
                .orElseThrow(()->new ResourceNotFoundException("User", "email", user.getEmail()));
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

    @Override
    public User getUser(String userName) {
        return userRepository.findByUserName(userName).
                orElseThrow(()->new ResourceNotFoundException("User", "username", userName));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto registerNewUser(UserDto userDto) {

        Optional<User> user1 = userRepository.findByEmail(userDto.getEmail());
        if(user1.isPresent()){
            throw new RuntimeException("User Already exist ");
        }

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        User user = modelMapper.map(userDto, User.class);


        user.setPassword(this.passwordEncoder.encode(user.getPassword()));

        // roles
        Role role = this.roleRepository.findById(AppConstants.NORMAL_USER).orElseThrow(()->new RuntimeException("Role not found"));

        user.getRoles().add(role);

        User newUser = this.userRepository.save(user);

        return modelMapper.map(newUser,UserDto.class);
    }
}

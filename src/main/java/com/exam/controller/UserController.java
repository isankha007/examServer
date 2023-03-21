package com.exam.controller;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user){
        try {
            Role role1=new Role();
            role1.setRoleId(45L);
            role1.setRoleName("NORMAL");

            user.getRoles().add(role1);
            User savedUser = userService.createUser(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(new User(),HttpStatus.CONFLICT);
        }


    }

    @GetMapping("/{userName}")
    public ResponseEntity<User> getUser(@PathVariable String userName){
        User user = userService.getUser(userName);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
         userService.deleteUser(id);
        return ResponseEntity.ok("User Deleted");
    }

}

package com.example.redisapi.controller;

import com.example.redisapi.model.User;
import com.example.redisapi.repository.UserDao;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping("/addUsers")
    public User createUser(@RequestBody User user) {
        user.setId(UUID.randomUUID().toString());
        return userDao.save(user);
    }

    @GetMapping("/getUser/{userId}")
    public User getUser(@PathVariable("userId") String userId) {
        return userDao.get(userId);
    }

    @GetMapping("/getAllUsers")
    public Map<Object,Object> getAllUsers() {
        return userDao.findAll();
    }

    @DeleteMapping("/deleteUser/{userId}")
    public void deleteUser(@PathVariable("userId") String userId) {
        userDao.delete(userId);
    }

}

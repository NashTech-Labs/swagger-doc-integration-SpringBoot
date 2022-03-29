package com.controller;
import com.model.User;
import com.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type User controller.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    /**
     * The Logger.
     */
    Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * The User service.
     */
    @Autowired
    UserServiceImpl userService;

    /**
     * Get all users list.
     *
     * @return the list
     */
//get All user
    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    /**
     * Gets user.
     *
     * @param username the username
     * @return the user
     */
//get single user
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return userService.getUser(username);
    }

}

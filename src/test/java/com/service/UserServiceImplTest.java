package com.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.model.User;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * The type User service impl test.
 */
@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * Test constructor.
     */
    @Test
    void testConstructor() {
        UserServiceImpl actualUserServiceImpl = new UserServiceImpl();
        List<User> expectedAllUsers = actualUserServiceImpl.userList;
        assertSame(expectedAllUsers, actualUserServiceImpl.getAllUsers());
    }

    /**
     * Test get user.
     */
    @Test
    void testGetUser() {
        assertNull(this.userServiceImpl.getUser("janedoe"));
    }

    /**
     * Test get user 2.
     */
    @Test
    void testGetUser2() {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by getUser(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.userServiceImpl.getUser("Akshit");
    }
}


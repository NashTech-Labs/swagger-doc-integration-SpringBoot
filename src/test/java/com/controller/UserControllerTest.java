package com.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.model.User;
import com.service.UserServiceImpl;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * The type User controller test.
 */
@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @Autowired
    private UserController userController;

    @MockBean
    private UserServiceImpl userServiceImpl;

    /**
     * Test get all users.
     *
     * @throws Exception the exception
     */
    @Test
    void testGetAllUsers() throws Exception {
        when(this.userServiceImpl.getAllUsers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Test get all users 2.
     *
     * @throws Exception the exception
     */
    @Test
    void testGetAllUsers2() throws Exception {
        when(this.userServiceImpl.getAllUsers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/users/");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Test get user.
     *
     * @throws Exception the exception
     */
    @Test
    void testGetUser() throws Exception {
        when(this.userServiceImpl.getUser((String) any()))
                .thenReturn(new User("janedoe", "iloveyou", "jane.doe@example.org"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/{username}", "janedoe");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"username\":\"janedoe\",\"password\":\"iloveyou\",\"email\":\"jane.doe@example.org\"}"));
    }

    /**
     * Test get user 2.
     *
     * @throws Exception the exception
     */
    @Test
    void testGetUser2() throws Exception {
        when(this.userServiceImpl.getUser((String) any()))
                .thenReturn(new User("janedoe", "iloveyou", "jane.doe@example.org"));
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/users/{username}", "janedoe");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"username\":\"janedoe\",\"password\":\"iloveyou\",\"email\":\"jane.doe@example.org\"}"));
    }
}


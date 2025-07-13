package com.gocevd.petstore.web;

import com.gocevd.petstore.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @Test
    void listUsers_returnsOkAndInvokesService() throws Exception {
        mockMvc.perform(get("/api/list-users"))
                .andExpect(status().isOk());
        verify(userService).listUsers();
    }

    @Test
    void createUsers_returnsOkAndInvokesService() throws Exception {
        mockMvc.perform(post("/api/create-users"))
                .andExpect(status().isOk());
        verify(userService).createUsers();
    }
}

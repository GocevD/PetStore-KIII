package com.gocevd.petstore.web;

import com.gocevd.petstore.service.PetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PetController.class)
public class PetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PetService petService;

    @Test
    void listPets_returnsOkAndInvokesService() throws Exception {
        mockMvc.perform(get("/api/list-pets"))
                .andExpect(status().isOk());
        verify(petService).listPets();
    }

    @Test
    void createPets_returnsOkAndInvokesService() throws Exception {
        mockMvc.perform(post("/api/create-pets"))
                .andExpect(status().isOk());
        verify(petService).createPets();
    }
}

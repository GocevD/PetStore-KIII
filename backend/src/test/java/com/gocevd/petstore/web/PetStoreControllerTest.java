package com.gocevd.petstore.web;

import com.gocevd.petstore.service.HistoryLogService;
import com.gocevd.petstore.service.PetStoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PetStoreController.class)
public class PetStoreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PetStoreService petStoreService;
    @MockitoBean
    private HistoryLogService historyLogService;

    @Test
    void buy_returnsOkAndInvokesService() throws Exception {
        mockMvc.perform(post("/api/buy"))
                .andExpect(status().isOk());
        verify(petStoreService).buy();
    }

    @Test
    void historyLog_returnsOkAndInvokesService() throws Exception {
        mockMvc.perform(get("/api/history"))
                .andExpect(status().isOk());
        verify(historyLogService).historyLog();
    }
}

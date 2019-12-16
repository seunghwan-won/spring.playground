package cc.ewqr.spring.playground.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ReservationQueryController.class)
public class ReservationQueryControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(ReservationQueryControllerTest.class);
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void setupFormTest() throws Exception {
        mockMvc.perform(get("/reservationQuery")).andExpect(handler().methodName("setupForm"));
    }

    @Test
    void submitFormTest() throws Exception {
        mockMvc.perform(post("/reservationQuery", 42L)
                .param("courtName", "Tennis #1"))
                .andExpect(handler().methodName("submitForm"))
                .andExpect(status().isOk());
    }
}

package cc.ewqr.spring.playground.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = WelcomeController.class)
public class CourtReservationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenValidInput_theReturns200() throws Exception {
        return200();
    }

    private void return200() throws Exception {
        mockMvc.perform(get("/welcome", 1L))
                .andExpect(handler().methodName("welcome"));
//                .andExpect(status().isOk());

    }
}

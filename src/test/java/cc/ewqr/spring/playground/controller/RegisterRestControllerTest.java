package cc.ewqr.spring.playground.controller;

import cc.ewqr.spring.playground.model.ErrorResult;
import cc.ewqr.spring.playground.repository.RegisterUseCase;
import cc.ewqr.spring.playground.model.User;
import cc.ewqr.spring.playground.model.UserResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static cc.ewqr.spring.playground.controller.ResponseBodyMatchers.responseBody;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = RegisterRestController.class)
public class RegisterRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RegisterUseCase registerUseCase;

    @Test
    void whenValidInput_theReturns200() throws Exception {
        UserResource user = getUserResource();
        return200(user);
    }

    private void return200(UserResource user) throws Exception {
        mockMvc.perform(post("/forums/42/register", 42L)
                .param("sendWelcomeEmail", "true")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());
    }

    private MvcResult return200Result(UserResource user) throws Exception {
        return mockMvc.perform(post("/forums/42/register", 42L)
                .contentType("application/json")
                .param("sendWelcomeEmail", "true")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void whenNullValue_thenReturns400() throws Exception {
        UserResource user = getNullUserResource();
        return400(user);
    }

    private UserResource getNullUserResource() {
        return new UserResource(null, "seunghwan@seeroo.co.kr");
    }

    private void return400(UserResource user) throws Exception {
        mockMvc.perform(post("/forums/42/register", 42L)
                .contentType("application/json")
                .param("sendWelcomeEmail", "true")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isBadRequest());
    }

    private MvcResult return400Result(UserResource user) throws Exception {
        return mockMvc.perform(post("/forums/42/register", 42L)
                .contentType("application/json")
                .param("sendWelcomeEmail", "true")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void whenValidInput_thenMapsToBusinessModel() throws Exception {
        UserResource user = getUserResource();
        return200(user);
        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(registerUseCase, times(1)).registerUser(userCaptor.capture(), eq(true));
    }

    private UserResource getUserResource() {
        return new UserResource("seunghwan.won", "seunghwan.won@seeroo.co.kr");
    }

    @Test
    void whenValidInput_thenReturnsUserResource() throws Exception {
        UserResource user = getUserResource();
        MvcResult result = mockMvc.perform(post("/forums/42/register", 42L)
                .contentType("application/json")
                .param("sendWelcomeEmail", "true")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andReturn();
        UserResource expectedResponseBody = user;
        String actualResponseBody = result.getResponse().getContentAsString();
        assertThat(objectMapper.writeValueAsString(expectedResponseBody))
                .isEqualToIgnoringWhitespace(actualResponseBody);
    }

    @Test
    void whenNullValue_thenReturn400AndErrorResult() throws Exception {
        UserResource user = getNullUserResource();
        MvcResult result = return400Result(user);

        ErrorResult expectedErrorResponse = new ErrorResult("name", "must not be null");
        String actualResponseBody =
                result.getResponse().getContentAsString();
        String expectedResponseBody =
                objectMapper.writeValueAsString(expectedErrorResponse);
        assertThat(expectedResponseBody)
                .isEqualToIgnoringWhitespace(actualResponseBody);
    }

    @Test
    void whenValidInput_thenReturnsUserResource_withFluentApi() throws Exception {
        UserResource user = getUserResource();
        UserResource expected  = user;
        mockMvc.perform(post("/forums/{forumsId}/register", 42L)
            .contentType("application/json")
            .param("sendWelcomeEmail","true")
            .content(objectMapper.writeValueAsString(user)))
            .andExpect(status().isOk())
            .andExpect(responseBody().containsObjectAsJson(expected, UserResource.class));
    }

    @Test
    void whenNullValue_thenReturns400AndErrorResult_withFluentApi() throws Exception  {
        UserResource user = getNullUserResource();
        mockMvc.perform(post("/forums/{forumsId}/register", 42L)
                .contentType("application/json")
                .param("sendWelcomeEmail","true")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isBadRequest())
                .andExpect(responseBody().containsError("name", "must not be null"));
    }
}

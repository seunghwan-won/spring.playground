package cc.ewqr.spring.playground;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ResponseBodyMatchers {
    private ObjectMapper objectMapper = new ObjectMapper();

   public <T>ResultMatcher containsObjectAsJson(Object expectedObject, Class<T> targetClass) {
       return mvcResult -> {
           String json = mvcResult.getResponse().getContentAsString();
           T actualObject = objectMapper.readValue(json, targetClass);
           assertThat(expectedObject).isEqualToComparingFieldByField(actualObject);
       };
   }

   public ResultMatcher containsError(String expectedFieldName, String expectedMessage) {
       return mvcResult -> {
           String json = mvcResult.getResponse().getContentAsString();
           ErrorResult errorResult = objectMapper.readValue(json, ErrorResult.class);
           List<FieldValidationError> fieldErrors = errorResult.getFieldErrors().stream()
                   .filter(fieldError -> fieldError.getField().equals(expectedFieldName))
                   .filter(fieldError -> fieldError.getMessage().equals(expectedMessage))
                   .collect(Collectors.toList());
           assertThat(fieldErrors)
                   .hasSize(1)
                   .withFailMessage("expecting exactly 1 error message with field name '%s' and message '%s'",
                           expectedFieldName, expectedMessage);
       };
   }

   static ResponseBodyMatchers responseBody() {
       return new ResponseBodyMatchers();
   }
}

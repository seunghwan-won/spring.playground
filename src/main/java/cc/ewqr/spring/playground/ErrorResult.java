package cc.ewqr.spring.playground;

import java.util.ArrayList;
import java.util.List;

public class ErrorResult {
    private List<FieldValidationError> fieldErrorList = new ArrayList<>();

    public ErrorResult() {
    }

    public ErrorResult(String field, String message) {
        this.fieldErrorList.add(new FieldValidationError(field, message));
    }

    public List<FieldValidationError> getFieldErrors() {
        return fieldErrorList;
    }
}

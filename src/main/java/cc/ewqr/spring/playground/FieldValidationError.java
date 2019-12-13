package cc.ewqr.spring.playground;

public class FieldValidationError {
    private String field;
    private String message;

    public FieldValidationError() {
    }

    public FieldValidationError(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}

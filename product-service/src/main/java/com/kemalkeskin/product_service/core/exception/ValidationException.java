package com.kemalkeskin.product_service.core.exception;

import java.util.Map;

public class ValidationException extends ProblemDetails{

    private Map<String,String>validationErrors;

    public ValidationException() {

    }

    public ValidationException(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public Map<String, String> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }
}

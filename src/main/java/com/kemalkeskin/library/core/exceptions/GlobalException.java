
package com.kemalkeskin.library.core.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetails handlerExceptions(BusinessException businessException){
        return new ProblemDetails(businessException.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetails handlerExceptions(MethodArgumentNotValidException methodArgumentNotValidException){

        ValidationException validationException=new ValidationException();
        validationException.setMessage("VALIDATION.EXCEPTİON");

        validationException.setValidationErrors(new HashMap<String, String>());

        for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            validationException.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());

        }

        return validationException;
    }

  /*  @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetails handleBusinessException(BusinessException ex) {
        // Hangi metodda hatanın çıktığını bulmak için stack trace'den ilk elemanı alalım
        StackTraceElement element = ex.getStackTrace()[0];
        String methodName = element.getClassName() + "." + element.getMethodName();

        return new ProblemDetails(ex.getMessage());
    }*/
}

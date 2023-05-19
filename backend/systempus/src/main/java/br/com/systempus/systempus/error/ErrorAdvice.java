package br.com.systempus.systempus.error;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.resource.beans.container.internal.NotYetReadyException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.converter.HttpMessageNotReadableException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleNotFoundException(NotFoundException exception, HttpServletRequest request){
        ApiError error = new ApiError(HttpStatus.NOT_FOUND.value(), exception.getMessage(), request.getServletPath());
        return error;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleNotReadableException(HttpMessageNotReadableException exception, HttpServletRequest request){
        String msgError = "JSON Request mal formado!";
        Map<String, String> validationErrors = new HashMap<>();
        validationErrors.put("error", exception.getMostSpecificCause().getMessage());


        ApiError error = new ApiError(HttpStatus.BAD_REQUEST.value(), msgError , request.getServletPath());
        error.setValidationErrors(validationErrors);
        return error;
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleIllegalStateException(IllegalStateException exception, HttpServletRequest request){
        ApiError error = new ApiError(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), request.getServletPath());
        return error;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleMethodArgNotValid(MethodArgumentNotValidException exception, HttpServletRequest request){
        ApiError erro = new ApiError(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), request.getServletPath());
        BindingResult bindingResult = exception.getBindingResult();
        Map<String, String> validationErrors = new HashMap<>();
        for(FieldError fieldError : bindingResult.getFieldErrors()){
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        erro.setValidationErrors(validationErrors);
        return erro;
    }
}

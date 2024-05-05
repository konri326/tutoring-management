package pl.gontarczyk.tutoringmanagement.exception;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.gontarczyk.tutoringmanagement.exception.model.ExceptionDto;
import pl.gontarczyk.tutoringmanagement.exception.model.ExceptionsDto;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDto entityNotFoundExceptionHandler(EntityNotFoundException ex) {
        return new ExceptionDto(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionsDto methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        ExceptionsDto exceptionsDto = new ExceptionsDto();
        ex.getFieldErrors()
                .forEach(error -> exceptionsDto.getErrors().put(error.getField(), error.getDefaultMessage()));
        return exceptionsDto;
    }

    @ExceptionHandler(EntityExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto entityExistsExceptionHandler(EntityExistsException ex) {
        return new ExceptionDto(ex.getMessage());
    }
}
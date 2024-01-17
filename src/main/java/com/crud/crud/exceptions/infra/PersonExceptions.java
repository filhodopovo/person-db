package com.crud.crud.exceptions.infra;

import com.crud.crud.exceptions.model.PersonExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Component("PersonExceptionsAdvice")
public class PersonExceptions extends ResponseEntityExceptionHandler {
    private PersonExceptionModel model;

    @ExceptionHandler(PersonNullPointer.class)
    private ResponseEntity<PersonExceptionModel> notNull(PersonNullPointer exception) {
        model = new PersonExceptionModel(HttpStatus.BAD_REQUEST, 400, exception.getMessage());
        return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PersonNotFoundException.class)
    private ResponseEntity<PersonExceptionModel> personNotFound(PersonNotFoundException exception) {
        model = new PersonExceptionModel(HttpStatus.NOT_FOUND, 404, exception.getMessage());
        return new ResponseEntity<>(model, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PersonExistException.class)
    private ResponseEntity<PersonExceptionModel> personExist(PersonExistException exception) {
        model = new PersonExceptionModel(HttpStatus.NOT_ACCEPTABLE, 406, exception.getMessage());
        return new ResponseEntity<>(model, HttpStatus.NOT_ACCEPTABLE);
    }
}

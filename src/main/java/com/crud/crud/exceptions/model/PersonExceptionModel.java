package com.crud.crud.exceptions.model;

import org.springframework.http.HttpStatus;

public record PersonExceptionModel(HttpStatus status, Integer code, String message) {
}

package com.crud.crud.exceptions.infra;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PersonNullPointer extends RuntimeException {
    public PersonNullPointer() {
        super("Não permitimos valores vazios");
    }
}

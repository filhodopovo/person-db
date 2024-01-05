package com.crud.crud.services;

import com.crud.crud.view.dto.PersonRequestDto;
import com.crud.crud.view.dto.PersonResponseDto;

import java.util.List;

public interface PersonService {
    PersonResponseDto register(PersonRequestDto PersonRequestDto);

    List<PersonResponseDto> listAllPersons();

    PersonResponseDto personById(Long id);

    /**
     * @param id     The id of the person we want to update
     * @param person The data of the person, the same data will be turned into person data and after all will be turned into a personResponse
     * @return Will return personModel type which it'll be turned into a PersonResponse
     */
    PersonResponseDto updatePerson(Long id, PersonRequestDto person);

    /**
     * @param id will be the id of the person which we want to delete
     */
    void deleteById(Long id);
}

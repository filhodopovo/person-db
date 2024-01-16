package com.crud.crud.services;

import com.crud.crud.dtos.PersonRequestDto;
import com.crud.crud.dtos.PersonResponseDto;
import com.crud.crud.entities.Person;
import com.crud.crud.exceptions.infra.PersonExistException;
import com.crud.crud.exceptions.infra.PersonNotFoundException;
import com.crud.crud.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;
    private ModelMapper modelMapper;

    @Override
    public PersonResponseDto register(PersonRequestDto personRequestDto) {
        if (this.personRepository.findByEmail(personRequestDto.getEmail()) != null) throw new PersonExistException();
        Person model = modelMapper.map(personRequestDto, Person.class);
        return modelMapper.map(this.personRepository.save(model), PersonResponseDto.class);
    }

    @Override
    public List<PersonResponseDto> listAllPersons() {
        return this.personRepository.findAll().stream()
                .map(PersonResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public PersonResponseDto personById(Long id) {
        Person model = this.personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
        return modelMapper.map(model, PersonResponseDto.class);
    }

    @Override
    public PersonResponseDto updatePerson(Long id, PersonRequestDto person) {
        Person model = this.personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
        if (!person.getName().isEmpty()) model.setName(person.getName());
        if (!person.getEmail().isEmpty()) model.setEmail(person.getEmail());
        if (!person.getPassword().isEmpty()) model.setPassword(person.getPassword());
        if (!person.getAddress().isEmpty()) model.setAddress(person.getAddress());
        if (person.getIdade() != null) model.setIdade(person.getIdade());
        return modelMapper.map(this.personRepository.save(model), PersonResponseDto.class);
    }

    @Override
    public void deleteById(Long id) {
        Person model = this.personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
        this.personRepository.delete(model);
    }
}

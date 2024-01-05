package com.crud.crud.services;

import com.crud.crud.entity.PersonModel;
import com.crud.crud.exceptions.ResourceExistException;
import com.crud.crud.exceptions.ResourceNotFoundException;
import com.crud.crud.repositories.PersonRepository;
import com.crud.crud.view.dto.PersonRequestDto;
import com.crud.crud.view.dto.PersonResponseDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;
    private ModelMapper modelMapper;

    @Override
    public PersonResponseDto register(PersonRequestDto personRequestDto) {
        if (personRequestDto.getEmail() == null) throw new NullPointerException();
        PersonModel model = this.personRepository.findByEmail(personRequestDto.getEmail());
        if (model != null) throw new ResourceExistException();
        PersonModel personModel = modelMapper.map(personRequestDto, PersonModel.class);
        personModel = this.personRepository.save(personModel);
        return modelMapper.map(personModel, PersonResponseDto.class);
    }

    @Override
    public List<PersonResponseDto> listAllPersons() {
        List<PersonModel> personModels = this.personRepository.findAll();
        return personModels.stream()
                .map(e -> modelMapper.map(e, PersonResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PersonResponseDto personById(Long id) {
        Optional<PersonModel> personModelOptional = this.personRepository.findById(id);
        return personModelOptional.map(e -> modelMapper.map(e, PersonResponseDto.class))
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public PersonResponseDto updatePerson(Long id, PersonRequestDto person) {
        Optional<PersonModel> model = this.personRepository.findById(id);
        if (model.isEmpty()) throw new ResourceNotFoundException();

        PersonModel personModel = model.get();
        personModel.setterPersonModel(person);
        personModel = this.personRepository.save(personModel);
        return modelMapper.map(personModel, PersonResponseDto.class);
    }

    @Override
    public void deleteById(Long id) {
        Optional<PersonModel> model = this.personRepository.findById(id);
        this.personRepository.deleteById(model.orElseThrow(ResourceNotFoundException::new).getId());
    }
}

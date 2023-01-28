package com.example.organization_info.service.impl;

import com.example.organization_info.domain.Person;

import com.example.organization_info.dto.ResponseData;
import com.example.organization_info.repository.PersonRepository;
import com.example.organization_info.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository repository;

    @Override
    public ResponseData<Person> create(Person person) {
        ResponseData<Person> responseData = new ResponseData<>();
        try {
            Person saved = repository.save(person);
            responseData.setData(saved);
            responseData.setSuccess(true);
            responseData.setMessage("A new branch has been created");
            return responseData;
        }catch (Exception e){
            responseData.setSuccess(false);
            responseData.setMessage("Error in saving data !");
        }
        return responseData;
    }
    @Override
    public ResponseData<Person> update(Person person) {
        ResponseData<Person> responseData = new ResponseData<>();
        try {
            Optional<Person> byId = repository.findById(person.getId());
            if (byId.isPresent()) {
                Person saved = repository.save(person);
                responseData.setData(saved);
                responseData.setSuccess(true);
                responseData.setMessage("Successfully updated");
            }
        }catch (Exception e){
            responseData.setSuccess(false);
            responseData.setMessage("Error while updating data!");
        }
        return responseData;
    }

    @Override
    public ResponseData<Person> delete(Long id) {
        ResponseData<Person> responseData = new ResponseData<>();
        try {
            repository.deleteById(id);
            responseData.setMessage("Deleted data");
            responseData.setSuccess(true);
            return responseData;
        }catch (Exception e){
            responseData.setSuccess(false);
            responseData.setMessage("Error when deleting data");
        }
        return responseData;
    }

    @Override
    public ResponseData<Person> findOne(Long id) {
        ResponseData<Person> responseData = new ResponseData<>();
        try {
            Optional<Person> branch = repository.findById(id);
            if (branch.isPresent()) {
                responseData.setSuccess(true);
                responseData.setData(branch.get());
            }
        }catch (Exception e){
            responseData.setSuccess(false);
            responseData.setMessage("Error when getting data with id : " + id);
        }
        return responseData;
    }
}

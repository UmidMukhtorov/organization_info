package com.example.organization_info.service;

import com.example.organization_info.domain.Person;

import com.example.organization_info.dto.ResponseData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {

    ResponseData<Person> create(Person person);
    ResponseData<Person> update(Person person);
    ResponseData<Person> delete(Long person);

    ResponseData<Person> findOne(Long id);





}

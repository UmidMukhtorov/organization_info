package com.example.organization_info.controller;

import com.example.organization_info.domain.Organization;
import com.example.organization_info.domain.Person;
import com.example.organization_info.dto.ResponseData;
import com.example.organization_info.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService service;
    @PostMapping("/create")
    ResponseData<Person> create(@RequestBody Person person){
        return service.create(person);
    }


    @PatchMapping("/update")
    ResponseData<Person> update(@RequestBody Person person){
        return service.update(person);
    }

    @GetMapping("/get/{id}")
    ResponseData<Person> getOne(@PathVariable Long id){
        return service.findOne(id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseData<Person> delete(@PathVariable Long id){
        return service.delete(id);
    }

}

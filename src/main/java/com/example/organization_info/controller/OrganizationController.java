package com.example.organization_info.controller;

import com.example.organization_info.domain.Branches;
import com.example.organization_info.domain.Organization;
import com.example.organization_info.dto.ResponseData;
import com.example.organization_info.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organization")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService service;

    @PostMapping("/create")
    ResponseData<Organization> create(@RequestBody Organization organization){
        return service.create(organization);
    }


    @PatchMapping("/update")
    ResponseData<Organization> update(@RequestBody Organization organization){
        return service.update(organization);
    }

    @GetMapping("/get/{id}")
    ResponseData<Organization> getOne(@PathVariable Long id){
        return service.findOne(id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseData<Organization> delete(@PathVariable Long id){
        return service.delete(id);
    }

}

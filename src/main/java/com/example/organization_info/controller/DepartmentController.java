package com.example.organization_info.controller;

import com.example.organization_info.domain.Branches;
import com.example.organization_info.domain.Department;
import com.example.organization_info.dto.ResponseData;
import com.example.organization_info.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService service;

    @PostMapping("/create")
    ResponseData<Department> create(@RequestBody Department department){
        return service.create(department);
    }


    @PatchMapping("/update/")
    ResponseData<Department> update(@RequestBody Department department){
        return service.update(department);
    }

    @GetMapping("/get/{id}")
    ResponseData<Department> getOne(@PathVariable Long id){
        return service.findOne(id);
    }

    @DeleteMapping("/delete{id}")
    ResponseData<Department> delete(@PathVariable Long id){
        return service.delete(id);
    }
}

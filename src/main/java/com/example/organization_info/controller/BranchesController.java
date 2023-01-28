package com.example.organization_info.controller;

import com.example.organization_info.domain.Branches;
import com.example.organization_info.dto.ResponseData;
import com.example.organization_info.service.BranchesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/branch")
@RequiredArgsConstructor
public class BranchesController {

    private final BranchesService service;


    @PostMapping("/create")
    ResponseData<Branches> create(@RequestBody Branches branches){
        return service.create(branches);
    }


    @PatchMapping("/update")
    ResponseData<Branches> update(@RequestBody Branches branches){
        return service.update(branches);
    }

    @GetMapping("/get/{id}")
    ResponseData<Branches> getOne(@PathVariable Long id){
        return service.findOne(id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseData<Branches> delete(@PathVariable Long id){
        return service.delete(id);
    }
}

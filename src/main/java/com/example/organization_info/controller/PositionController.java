package com.example.organization_info.controller;

import com.example.organization_info.domain.Person;
import com.example.organization_info.domain.Position;
import com.example.organization_info.dto.ResponseData;
import com.example.organization_info.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/position")
@RequiredArgsConstructor
public class PositionController {
    private final PositionService service;
    @PostMapping("/create")
    ResponseData<Position> create(@RequestBody Position position){
        return service.create(position);
    }


    @PatchMapping("/update")
    ResponseData<Position> update(@RequestBody Position position){
        return service.update(position);
    }

    @GetMapping("/get/{id}")
    ResponseData<Position> getOne(@PathVariable Long id){
        return service.findOne(id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseData<Position> delete(@PathVariable Long id){
        return service.delete(id);
    }

}

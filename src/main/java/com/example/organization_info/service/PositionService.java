package com.example.organization_info.service;

import com.example.organization_info.domain.Position;

import com.example.organization_info.dto.ResponseData;
import org.springframework.stereotype.Service;

@Service
public interface PositionService {

    ResponseData<Position> create(Position position);
    ResponseData<Position> update(Position position);
    ResponseData<Position> delete(Long id);

    ResponseData<Position> findOne(Long id);



}

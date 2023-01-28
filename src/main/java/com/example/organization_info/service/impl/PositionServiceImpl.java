package com.example.organization_info.service.impl;

import com.example.organization_info.domain.Position;
import com.example.organization_info.dto.ResponseData;
import com.example.organization_info.repository.PositionRepository;
import com.example.organization_info.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository repository;

    @Override
    public ResponseData<Position> create(Position position) {
        ResponseData<Position> responseData = new ResponseData<>();
        try {
            Position saved = repository.save(position);
            responseData.setData(saved);
            responseData.setSuccess(true);
            responseData.setMessage("A new branch has been created");
            return responseData;
        } catch (Exception e) {
            responseData.setSuccess(false);
            responseData.setMessage("Error in saving data !");
        }
        return responseData;
    }

    @Override
    public ResponseData<Position> update(Position person) {
        ResponseData<Position> responseData = new ResponseData<>();
        try {
            Optional<Position> byId = repository.findById(person.getId());
            if (byId.isPresent()) {
                Position saved = repository.save(person);
                responseData.setData(saved);
                responseData.setSuccess(true);
                responseData.setMessage("Successfully updated");
                return responseData;

            }

        } catch (Exception e) {
            responseData.setSuccess(false);
            responseData.setMessage("Error while updating data!");
        }
        return responseData;
    }

    @Override
    public ResponseData<Position> delete(Long id) {
        ResponseData<Position> responseData = new ResponseData<>();
        try {
            repository.deleteById(id);
            responseData.setMessage("Deleted data");
            responseData.setSuccess(true);
            return responseData;
        } catch (Exception e) {
            responseData.setSuccess(false);
            responseData.setMessage("Error when deleting data");
        }
        return responseData;
    }

    @Override
    public ResponseData<Position> findOne(Long id) {
        ResponseData<Position> responseData = new ResponseData<>();
        try {
            Optional<Position> branch = repository.findById(id);
            if (branch.isPresent()) {
                responseData.setSuccess(true);
                responseData.setData(branch.get());
            }
        } catch (Exception e) {
            responseData.setSuccess(false);
            responseData.setMessage("Error when getting data with id : " + id);
        }
        return responseData;
    }
}

package com.example.organization_info.service.impl;

import com.example.organization_info.domain.Branches;
import com.example.organization_info.dto.ResponseData;
import com.example.organization_info.repository.BranchesRepository;
import com.example.organization_info.service.BranchesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BranchesServiceImpl implements BranchesService {

    private final BranchesRepository repository;

    @Override
    public ResponseData<Branches> create(Branches branches) {
        ResponseData<Branches> responseData = new ResponseData<>();
        try {
            Branches saved = repository.save(branches);
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
    public ResponseData<Branches> update(Branches branches) {
        ResponseData<Branches> responseData = new ResponseData<>();
        try {
            Optional<Branches> byId = repository.findById(branches.getId());
            if (byId.isPresent()){
                Branches saved = repository.save(branches);
                responseData.setData(saved);
                responseData.setSuccess(true);
                responseData.setMessage("Successfully updated");
                return responseData;
            }

        }catch (Exception e){
            responseData.setSuccess(false);
            responseData.setMessage("Error while updating data!");
        }
        return responseData;
    }

    @Override
    public ResponseData<Branches> delete(Long id) {
        ResponseData<Branches> responseData = new ResponseData<>();
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
    public ResponseData<Branches> findOne(Long id) {
        ResponseData<Branches> responseData = new ResponseData<>();
        try {
            Optional<Branches> branch = repository.findById(id);
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

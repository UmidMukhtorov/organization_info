package com.example.organization_info.service.impl;



import com.example.organization_info.domain.Organization;
import com.example.organization_info.dto.ResponseData;
import com.example.organization_info.repository.OrganizationRepository;
import com.example.organization_info.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository repository;

    @Override
    public ResponseData<Organization> create(Organization organization) {
        ResponseData<Organization> responseData = new ResponseData<>();
        try {
            Organization saved = repository.save(organization);
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
    public ResponseData<Organization> update(Organization organization) {
        ResponseData<Organization> responseData = new ResponseData<>();
        try {
            Optional<Organization> byId = repository.findById(organization.getId());
            if (byId.isPresent()){
                Organization saved = repository.save(organization);
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
    public ResponseData<Organization> delete(Long id) {
        ResponseData<Organization> responseData = new ResponseData<>();
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
    public ResponseData<Organization> findOne(Long id) {
        ResponseData<Organization> responseData = new ResponseData<>();
        try {
            Optional<Organization> branch = repository.findById(id);
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

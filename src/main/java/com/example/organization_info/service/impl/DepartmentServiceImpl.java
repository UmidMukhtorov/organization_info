package com.example.organization_info.service.impl;

import com.example.organization_info.domain.Branches;
import com.example.organization_info.domain.Department;
import com.example.organization_info.domain.Organization;
import com.example.organization_info.dto.ResponseData;
import com.example.organization_info.repository.DepartmentRepository;
import com.example.organization_info.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;


    @Override
    public ResponseData<Department> create(Department department) {
        ResponseData<Department> responseData = new ResponseData<>();
        try {
            Department saved = repository.save(department);
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
    public ResponseData<Department> update(Department department) {
        ResponseData<Department> responseData = new ResponseData<>();
        try {
            Optional<Department> byId = repository.findById(department.getId());
            if (byId.isPresent()){
                Department saved = repository.save(department);
                responseData.setData(saved);
                responseData.setSuccess(true);
                responseData.setMessage("Successfully updated");
                return responseData;

            }
            Department saved = repository.save(department);
            responseData.setData(saved);
            responseData.setSuccess(true);
            responseData.setMessage("Successfully updated");
        }catch (Exception e){
            responseData.setSuccess(false);
            responseData.setMessage("Error while updating data!");
        }
        return responseData;
    }

    @Override
    public ResponseData<Department> delete(Long id) {
        ResponseData<Department> responseData = new ResponseData<>();
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
    public ResponseData<Department> findOne(Long id) {
        ResponseData<Department> responseData = new ResponseData<>();
        try {
            Optional<Department> branch = repository.findById(id);
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

package com.example.organization_info.service;

import com.example.organization_info.domain.Branches;
import com.example.organization_info.domain.Department;
import com.example.organization_info.domain.Organization;
import com.example.organization_info.dto.ResponseData;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
    ResponseData<Department> create(Department department);
    ResponseData<Department> update(Department department);
    ResponseData<Department> delete(Long department);

    ResponseData<Department> findOne(Long id);
}

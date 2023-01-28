package com.example.organization_info.service;

import com.example.organization_info.domain.Organization;
import com.example.organization_info.dto.ResponseData;
import org.springframework.stereotype.Service;

@Service
public interface OrganizationService {

    ResponseData<Organization> create(Organization organization);
    ResponseData<Organization> update(Organization organization);
    ResponseData<Organization> delete(Long organization);

    ResponseData<Organization> findOne(Long id);
}

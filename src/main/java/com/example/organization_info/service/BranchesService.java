package com.example.organization_info.service;

import com.example.organization_info.domain.Branches;
import com.example.organization_info.dto.ResponseData;
import org.springframework.stereotype.Service;

@Service
public interface BranchesService {
    ResponseData<Branches> create(Branches branches);
    ResponseData<Branches> update(Branches branches);
    ResponseData<Branches> delete(Long branches);

    ResponseData<Branches> findOne(Long id);

}

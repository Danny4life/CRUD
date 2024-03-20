package com.osiki.crudapi.services.impl;

import com.osiki.crudapi.dto.DepartmentDto;
import com.osiki.crudapi.entity.DepartmentEntity;
import com.osiki.crudapi.repository.DepartmentRepository;
import com.osiki.crudapi.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    @Override
    public List<DepartmentEntity> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }
}

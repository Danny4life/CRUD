package com.osiki.crudapi.services;

import com.osiki.crudapi.dto.DepartmentDto;
import com.osiki.crudapi.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentService {
    List<DepartmentEntity> getAllDepartments();

    DepartmentEntity saveDepartment(DepartmentEntity departmentEntity);

    String joinDept(Long id, DepartmentDto dto);

    List<DepartmentDto> getDeptByEmployeeId(Long employeeId);
}

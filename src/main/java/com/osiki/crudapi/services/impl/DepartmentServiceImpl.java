package com.osiki.crudapi.services.impl;

import com.osiki.crudapi.dto.DepartmentDto;
import com.osiki.crudapi.entity.DepartmentEntity;
import com.osiki.crudapi.entity.EmployeeEntity;
import com.osiki.crudapi.repository.DepartmentRepository;
import com.osiki.crudapi.repository.EmployeeRepository;
import com.osiki.crudapi.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final EmployeeRepository employeeRepository;
    @Override
    public List<DepartmentEntity> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }

    @Override
    public String joinDept(Long id, DepartmentDto dto) {

        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Employee not found"));

        DepartmentEntity departmentEntity = new DepartmentEntity();

        departmentEntity.setDepartmentName(dto.getDepartmentName());
        departmentEntity.setEmployee(employee);

        departmentRepository.save(departmentEntity);

        return "Join department successfully";
    }

    @Override
    public List<DepartmentDto> getDeptByEmployeeId(Long employeeId) {

        List<DepartmentEntity> departmentEntities = departmentRepository.findByEmployee_Id(employeeId);

        return departmentEntities.stream()
                .map(dept -> new DepartmentDto(
                        dept.getId(),
                        dept.getDepartmentName()
                )).collect(Collectors.toList());
    }
}

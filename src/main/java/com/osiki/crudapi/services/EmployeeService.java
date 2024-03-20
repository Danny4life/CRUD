package com.osiki.crudapi.services;

import com.osiki.crudapi.dto.EmployeeDto;
import com.osiki.crudapi.entity.DepartmentEntity;
import com.osiki.crudapi.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
   EmployeeDto createEmployee(EmployeeDto employeeDto);

  //  EmployeeEntity createEmployee(EmployeeEntity employee, Long departmentId);

    List<EmployeeDto> getAllEmployees();

    boolean deleteEmployee(Long id);

    EmployeeDto getEmployeeById(Long id);

    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);
}

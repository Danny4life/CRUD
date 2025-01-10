package com.osiki.crudapi.services.impl;

import com.osiki.crudapi.entity.DepartmentEntity;
import com.osiki.crudapi.entity.EmployeeEntity;
import com.osiki.crudapi.dto.EmployeeDto;
import com.osiki.crudapi.repository.DepartmentRepository;
import com.osiki.crudapi.repository.EmployeeRepository;
import com.osiki.crudapi.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final DepartmentRepository departmentRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        // convert the employee into employee-entity to save in the db

        EmployeeEntity employeeEntity = new EmployeeEntity();

        // copy all the values from the employee into employee-entity
        BeanUtils.copyProperties(employeeDto, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employeeDto;
    }


    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        List<EmployeeDto> employeeDtos = employeeEntities
                .stream()
                .map(emp -> new EmployeeDto(
                        emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmailId()))
                .collect(Collectors.toList());
        return employeeDtos;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return true;
    }

    //get employee by id
    @Override
    public EmployeeDto getEmployeeById(Long id) {
        EmployeeEntity employeeEntity =
                employeeRepository.findById(id).get();
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employeeEntity, employeeDto);
        return employeeDto;
    }

    //update employee
    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity =
                employeeRepository.findById(id).get();
        // use the employeeEntity to update all the records in the employee
        employeeEntity.setEmailId(employeeDto.getEmailId());
        employeeEntity.setFirstName(employeeDto.getFirstName());
        employeeEntity.setLastName(employeeDto.getLastName());
        employeeRepository.save(employeeEntity);
        return employeeDto;
    }
}

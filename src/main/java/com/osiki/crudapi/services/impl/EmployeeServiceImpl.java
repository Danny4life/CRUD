package com.osiki.crudapi.services.impl;

import com.osiki.crudapi.entity.EmployeeEntity;
import com.osiki.crudapi.model.Employee;
import com.osiki.crudapi.repository.EmployeeRepository;
import com.osiki.crudapi.services.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {

        // convert the employee into employee-entity to save in the db

        EmployeeEntity employeeEntity = new EmployeeEntity();

        // copy all the values from the employee into employee-entity
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {

        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        List<Employee> employees = employeeEntities
                .stream()
                .map(emp -> new Employee(
                        emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmailId()))
                .collect(Collectors.toList());
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return true;
    }

    //get employee by id
    @Override
    public Employee getEmployeeById(Long id) {
        EmployeeEntity employeeEntity =
                employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    //update employee
    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        EmployeeEntity employeeEntity =
                employeeRepository.findById(id).get();
        // use the employeeEntity to update all the records in the employee
        employeeEntity.setEmailId(employee.getEmailId());
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeRepository.save(employeeEntity);
        return employee;
    }
}

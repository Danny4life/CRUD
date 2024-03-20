package com.osiki.crudapi.controller;

import com.osiki.crudapi.dto.EmployeeDto;
import com.osiki.crudapi.entity.EmployeeEntity;
import com.osiki.crudapi.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class EmployeeController {


    private final EmployeeService employeeService;


    @PostMapping("/employees")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto){

        return employeeService.createEmployee(employeeDto);

    }

//    @PostMapping("/employee/{departmentId}")
//    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee, @PathVariable Long departmentId){
//
//        return employeeService.createEmployee(employee, departmentId);
//
//    }

    @GetMapping("/employees")

    public List<EmployeeDto> getAllEmployees(){

        return employeeService.getAllEmployees();

    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        boolean deleted = false;
        deleted = employeeService.deleteEmployee(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        EmployeeDto employeeDto = null;
        employeeDto = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDto);
    }

    @PutMapping("/employees/{id}")

    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,
                                                      @RequestBody EmployeeDto employeeDto){

        employeeDto = employeeService.updateEmployee(id, employeeDto);
        return ResponseEntity.ok(employeeDto);

    }



}

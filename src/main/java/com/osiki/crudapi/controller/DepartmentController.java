package com.osiki.crudapi.controller;

import com.osiki.crudapi.dto.DepartmentDto;
import com.osiki.crudapi.entity.DepartmentEntity;
import com.osiki.crudapi.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;


    @GetMapping("/departments")
    public List<DepartmentEntity> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @PostMapping("/departments")
    public DepartmentEntity createDepartment(@RequestBody DepartmentEntity departmentEntity){
        return departmentService.saveDepartment(departmentEntity);

    }

    @PostMapping("/departments/{id}")
    public ResponseEntity<String> joinDepartment(@PathVariable("id") Long id,
                                         @RequestBody DepartmentDto dto){


        return ResponseEntity.ok(departmentService.joinDept(id, dto));

    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<DepartmentDto>> getDeptByEmployeeId(@PathVariable Long employeeId){
        List<DepartmentDto> departmentDtos = departmentService.getDeptByEmployeeId(employeeId);

        return ResponseEntity.ok(departmentDtos);
    }
}

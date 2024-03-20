package com.osiki.crudapi.controller;

import com.osiki.crudapi.entity.DepartmentEntity;
import com.osiki.crudapi.services.DepartmentService;
import lombok.RequiredArgsConstructor;
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
}

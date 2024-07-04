package com.osiki.crudapi.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "em_tb")
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "employeeModel", cascade = CascadeType.ALL)
    private List<DepartmentModel> departmentModels = new ArrayList<>();
}

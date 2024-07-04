package com.osiki.crudapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "de_tbl")
public class DepartmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deptName;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeModel employeeModel;
}

package com.osiki.crudapi.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String emailId;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<DepartmentEntity> departmentEntity = new ArrayList<>();


}

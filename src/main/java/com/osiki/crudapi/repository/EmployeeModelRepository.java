package com.osiki.crudapi.repository;

import com.osiki.crudapi.entity.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeModelRepository extends JpaRepository<EmployeeModel, Long> {
}

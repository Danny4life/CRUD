package com.osiki.crudapi.repository;

import com.osiki.crudapi.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

    List<DepartmentEntity> findByEmployee_Id(Long employeeId);
}

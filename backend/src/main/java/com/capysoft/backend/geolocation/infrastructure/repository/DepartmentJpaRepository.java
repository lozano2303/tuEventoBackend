package com.capysoft.backend.geolocation.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capysoft.backend.geolocation.domain.model.Department;

@Repository
public interface DepartmentJpaRepository extends JpaRepository<Department, Integer>{

    // metodo para encontrar un departamento por nombre
    Optional<Department> findByDepartmentName (String departmentName);

}

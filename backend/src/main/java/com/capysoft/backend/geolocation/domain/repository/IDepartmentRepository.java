package com.capysoft.backend.geolocation.domain.repository;

import java.util.List;
import java.util.Optional;

import com.capysoft.backend.geolocation.domain.model.Department;

public interface IDepartmentRepository {

    //buscar por id
    Optional<Department> findById(int department_id);

    //buscar por nombre
    Optional<Department> findByDepartmentName (String department_name);

    //obtener todos los departamentos
    List<Department> findAll ();

    //guardar o actualizar departamento
    Department save(Department department);

}

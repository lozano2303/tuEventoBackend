package com.capysoft.backend.geolocation.infrastructure.repository;

import org.springframework.stereotype.Repository;
import com.capysoft.backend.geolocation.domain.model.Department;
import com.capysoft.backend.geolocation.domain.repository.IDepartmentRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class DepartmentRepositoryImpl implements IDepartmentRepository{

    private final DepartmentJpaRepository departmentJPpaRepository;

    public DepartmentRepositoryImpl(DepartmentJpaRepository departmentJpaRepository) {
        this.departmentJPpaRepository = departmentJpaRepository;
    }

    //metodo de busqueda por id
    @Override
    public Optional<Department> findById (int departmentId){
        return departmentJPpaRepository.findById(departmentId);
    }

    //metodo de busqueda por nombre
    @Override
    public Optional<Department> findByDepartmentName(String departmentName){
        return departmentJPpaRepository.findByDepartmentName(departmentName);
    }

    //metodo para encontrar todos los registros
    @Override
    public List<Department> findAll(){
        return departmentJPpaRepository.findAll();
    }

    //metodo para guardar o actualizar
    @Override
    public Department save(Department department){
        return departmentJPpaRepository.save(department);
    }
}

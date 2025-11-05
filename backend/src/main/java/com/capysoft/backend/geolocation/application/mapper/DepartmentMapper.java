package com.capysoft.backend.geolocation.application.mapper;

import org.springframework.stereotype.Component;

import com.capysoft.backend.geolocation.application.dto.DepartmentRequestDTO;
import com.capysoft.backend.geolocation.application.dto.DepartmentResponseDTO;
import com.capysoft.backend.geolocation.domain.model.Department;

@Component
public class DepartmentMapper {

    //convertir de entidad a responseDTO
    public DepartmentResponseDTO toResponseDTO(Department department){
        if (department == null) return null;

        return new DepartmentResponseDTO(
            department.getDepartmentId(),
            department.getDepartmentName()
        );
    }

    //convertir de request a entidad
    public Department toEntity(DepartmentRequestDTO dto){
        if(dto == null) return null;

        Department department = new Department();
        department.setDepartmentName(dto.getDepartmentName());

        return department;
    }
}

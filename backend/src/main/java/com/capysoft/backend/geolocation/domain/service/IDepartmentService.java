package com.capysoft.backend.geolocation.domain.service;

import java.util.List;

import com.capysoft.backend.geolocation.application.dto.DepartmentRequestDTO;
import com.capysoft.backend.geolocation.application.dto.DepartmentResponseDTO;

public interface IDepartmentService {

    //metodos de la interfaz
    DepartmentResponseDTO create (DepartmentRequestDTO dto);

    List<DepartmentResponseDTO> getAll();

    DepartmentResponseDTO getById (int departmentId);

    List<DepartmentResponseDTO> getByDepartmentName (String departmentName);
}

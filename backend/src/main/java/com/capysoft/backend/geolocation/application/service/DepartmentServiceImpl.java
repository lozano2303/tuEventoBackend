package com.capysoft.backend.geolocation.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.capysoft.backend.geolocation.application.dto.DepartmentRequestDTO;
import com.capysoft.backend.geolocation.application.dto.DepartmentResponseDTO;
import com.capysoft.backend.geolocation.application.mapper.DepartmentMapper;
import com.capysoft.backend.geolocation.domain.model.Department;
import com.capysoft.backend.geolocation.domain.repository.IDepartmentRepository;
import com.capysoft.backend.geolocation.domain.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService{

    private final IDepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    //contructor de inyeccion de dependencias
    public DepartmentServiceImpl(IDepartmentRepository departmentRepository, DepartmentMapper departmentMapper){
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public DepartmentResponseDTO create (DepartmentRequestDTO dto){
        Department department = departmentMapper.toEntity(dto);
        Department savedDevDepartment = departmentRepository.save(department);
        return departmentMapper.toResponseDTO(savedDevDepartment);
    }

    @Override
    public List<DepartmentResponseDTO> getAll(){
        return departmentRepository.findAll()
                .stream()
                .map(departmentMapper::toResponseDTO)
                .collect((Collectors.toList()));
    }

    @Override
    public DepartmentResponseDTO getById(int departmentId){
        return departmentRepository.findById(departmentId)
                .map(departmentMapper::toResponseDTO)
                .orElse(null);
    }

    @Override
    public List<DepartmentResponseDTO> getByDepartmentName(String departmentName){
        return departmentRepository.findByDepartmentName(departmentName)
                .stream()
                .map(departmentMapper::toResponseDTO)
                .collect((Collectors.toList()));
    }

}

package com.capysoft.backend.user.application.service;

// importaciones necesarias
import com.capysoft.backend.user.application.dto.RoleRequestDTO;
import com.capysoft.backend.user.application.dto.RoleResponseDTO;
import com.capysoft.backend.user.application.mapper.RoleMapper;
import com.capysoft.backend.user.domain.model.Role;
import com.capysoft.backend.user.domain.repository.IRoleRepository;
import com.capysoft.backend.user.domain.service.IRoleService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//servicio de roles (crear, listar, buscar (por nombre))
@Service
public class RoleServiceImpl implements IRoleService{ //se implementa la interfaz IRoleService

    private final IRoleRepository roleRepository;

    public RoleServiceImpl(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleResponseDTO createRole(RoleRequestDTO dto){
        Role role = RoleMapper.toEntity(dto);
        Role saved = roleRepository.save(role);
        return RoleMapper.toDTO(saved);
    }

    @Override
    public List<RoleResponseDTO> getAllRoles(){
        return roleRepository.findAll().stream()
            .map(RoleMapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public RoleResponseDTO getRoleByName(String name){
        Role role = roleRepository.findByRoleName(name)
            .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        return RoleMapper.toDTO(role);
    }
}
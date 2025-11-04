package com.capysoft.backend.user.domain.service;

//importaciones necesarias
import com.capysoft.backend.user.application.dto.RoleRequestDTO;
import com.capysoft.backend.user.application.dto.RoleResponseDTO;

import java.util.List;

//interfaz del servicio de roles, define los metodos usados por el controlador (crear, listar, buscar por nombre)
public interface IRoleService {

    RoleResponseDTO createRole(RoleRequestDTO dto);
    List<RoleResponseDTO> getAllRoles();
    RoleResponseDTO getRoleByName(String name);
}

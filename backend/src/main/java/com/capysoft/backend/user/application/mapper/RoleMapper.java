package com.capysoft.backend.user.application.mapper;

import com.capysoft.backend.user.application.dto.RoleRequestDTO;
import com.capysoft.backend.user.application.dto.RoleResponseDTO;
import com.capysoft.backend.user.domain.model.Role;

public class RoleMapper {

    // mapea de RoleRequestDTO a entidad Role
    // para cuando el cliente envia datos al crear un rol nuevo
    public static Role toEntity(RoleRequestDTO dto){
        return new Role(0, dto.getRoleName());  // id en 0 pq este lo genera la bd
    }

    // mapea de entidad Role a RoleResponseDTO
    // para cuando se envian datos al cliente
    public static RoleResponseDTO toDTO(Role role){
        return new RoleResponseDTO(role.getRoleId(), role.getRoleName());
    }
}

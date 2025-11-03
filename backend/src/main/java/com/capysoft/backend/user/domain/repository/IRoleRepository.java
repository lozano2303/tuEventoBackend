package com.capysoft.backend.user.domain.repository;

import com.capysoft.backend.user.domain.model.Role;
import java.util.List;
import java.util.Optional;

// interfaz del repositorio para la entidad Role
public interface IRoleRepository {

    // metodos CRUD basicos
    Optional<Role> findByRoleName(String roleName);
    Role save(Role role);
    Optional<Role> findById(int roleId);
    List<Role> findAll();

}

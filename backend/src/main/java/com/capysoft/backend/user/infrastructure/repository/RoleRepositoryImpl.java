package com.capysoft.backend.user.infrastructure.repository;

//importaciones necesarias para JPA
import org.springframework.stereotype.Component;
import com.capysoft.backend.user.domain.model.Role;
import com.capysoft.backend.user.domain.repository.IRoleRepository;

import java.util.List;
import java.util.Optional;

// implementacion del repositorio IRoleRepository usando JPA
@Component
public class RoleRepositoryImpl implements IRoleRepository{

    //inyeccion del repositorio JPA
    private final RoleJpaRepository jpaRepository;

    //metodos CRUD basicos implementados usando JPA
    public RoleRepositoryImpl(RoleJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Role> findByRoleName(String roleName) {
        return Optional.ofNullable(jpaRepository.findByRoleName(roleName));
    }

    @Override
    public Role save(Role role) {
        return jpaRepository.save(role);
    }

    @Override
    public Optional<Role> findById(int roleId) {
        return jpaRepository.findById(roleId);
    }

    @Override
    public List<Role> findAll() {
        return jpaRepository.findAll();
    }
}

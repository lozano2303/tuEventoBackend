package com.capysoft.backend.user.infrastructure.repository;

//importaciones necesarias para JPA
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capysoft.backend.user.domain.model.Role;

//Definicion del repositorio RoleRepository para la entidad Role
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    //puede dejarse vacio si no se necesitan consultas personalizadas ya que JPA proporciona metodos CRUD basicos

    //Metodo personalizado para encontrar un rol por su nombre
    Role findByRoleName(String roleName);
}

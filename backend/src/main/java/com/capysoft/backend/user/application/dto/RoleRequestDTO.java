package com.capysoft.backend.user.application.dto;

//DTO = Data Transfer Object
//DTO para recibir datos de creacion o actualizacion de roles
//Contiene solo el nombre del rol
public class RoleRequestDTO {

    //Atributo del DTO
    private String roleName;

    //Constructores
    public RoleRequestDTO() {}

    public RoleRequestDTO(String roleName) {
        this.roleName = roleName;
    }

    //Getter y Setter
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}

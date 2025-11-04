package com.capysoft.backend.user.application.dto;

//DTO = Data Transfer Object
//DTO para enviar datos al cliente
//Contiene el id y el nombre del rol
public class RoleResponseDTO {

    //Atributos del DTO
    private int roleId;
    private String roleName;

    //Constructores
    public RoleResponseDTO() {}

    public RoleResponseDTO(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    //Getters y Setters
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

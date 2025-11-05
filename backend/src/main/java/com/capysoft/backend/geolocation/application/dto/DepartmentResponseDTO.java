package com.capysoft.backend.geolocation.application.dto;

public class DepartmentResponseDTO {

    //atributos
    private int departmentId;
    private String departmentName;

    //contructor vacio para JPA
    public DepartmentResponseDTO(){}

    //contructor con parametros
    public DepartmentResponseDTO(int departmentId, String departmentName){
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    //Getters y setters
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}

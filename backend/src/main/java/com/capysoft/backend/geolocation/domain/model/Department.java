package com.capysoft.backend.geolocation.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Definicion de la entidad Department
@Entity
@Table(name = "department")
public class Department {

    // Atributos de la entidad Department
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private int departmentId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    // Constructor vacio para JPA
    public Department() {}

    // Constructor con parametros
    public Department(int departmentId, String name) {
        this.departmentId = departmentId;
        this.name = name;
    }

    // Getters y Setters
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

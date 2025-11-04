package com.capysoft.backend.status.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "status")
public class Status {

    //atributos de la entidad status
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "status_id")
    private int statusId;

    @Column(name = "status_name", nullable = false)
    private String statusName;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "color_hex", length=7, nullable = false)
    private String colorHex;

    //constructor vacio
    public Status() {}

    //contructor con parametros
    public Status(int statusId, String statusName, String description, String type, String colorHex) {
        this.statusId = statusId;
        this.statusName = statusName;
        this.description = description;
        this.type = type;
        this.colorHex = colorHex;
    }
    //getters y setters

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }
}


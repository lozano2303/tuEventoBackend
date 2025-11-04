package com.capysoft.backend.status.application.dto;

public class StatusResponseDTO {

    //Atributos
    private int statusId;
    private String statusName;
    private String description;
    private String type;
    private String colorHex;

    //constructor vacio
    public StatusResponseDTO(){}

    //constructor con parametros
    public StatusResponseDTO(int statusId, String statusName, String description, String type, String colorHex) {
        this.statusId = statusId;
        this.statusName = statusName;
        this.description = description;
        this.type = type;
        this.colorHex = colorHex;
    }

    //Getters and Setters
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

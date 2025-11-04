package com.capysoft.backend.status.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StatusRequestDTO {

    @NotBlank
    @Size(max = 50)
    private String statusName;

    @Size(max = 150)
    private String description;

    @NotBlank
    @Size(max = 30)
    private String type;

    @Size(max = 7)
    private String colorHex;

    // Getters and Setters
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

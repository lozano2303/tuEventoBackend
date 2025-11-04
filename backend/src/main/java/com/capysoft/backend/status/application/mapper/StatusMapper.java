package com.capysoft.backend.status.application.mapper;

import com.capysoft.backend.status.domain.model.Status;

import org.springframework.stereotype.Component;

import com.capysoft.backend.status.application.dto.StatusRequestDTO;
import com.capysoft.backend.status.application.dto.StatusResponseDTO;

@Component
public class StatusMapper {

    //convertir de entidad a responseDTO
    public StatusResponseDTO toResponseDTO(Status status){
        if (status == null) return null;

        return new StatusResponseDTO(
                status.getStatusId(),
                status.getStatusName(),
                status.getDescription(),
                status.getType(),
                status.getColorHex()
        );
    }


    //convertir de requestDTO a entidad
    public Status toEntity(StatusRequestDTO dto){
        if (dto == null) return null;

        Status status = new Status();
        status.setStatusName(dto.getStatusName());
        status.setDescription(dto.getDescription());
        status.setType(dto.getType());
        status.setColorHex(dto.getColorHex());

        return status;
    }

}

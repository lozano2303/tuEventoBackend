package com.capysoft.backend.status.domain.service;

import java.util.List;

import com.capysoft.backend.status.application.dto.StatusRequestDTO;
import com.capysoft.backend.status.application.dto.StatusResponseDTO;

public interface IStatusService {

    //metodos en la interfaz
    StatusResponseDTO create (StatusRequestDTO dto);

    List<StatusResponseDTO> getAll();

    StatusResponseDTO getById (int statusId);

    List<StatusResponseDTO> getByType (String type);
}

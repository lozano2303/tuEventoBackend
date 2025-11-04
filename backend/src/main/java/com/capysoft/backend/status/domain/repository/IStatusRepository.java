package com.capysoft.backend.status.domain.repository;

import com.capysoft.backend.status.domain.model.Status;

import java.util.List;
import java.util.Optional;

public interface IStatusRepository {

    //buscar por id
    Optional<Status> findById(int statusId);

    //buscar por nombre y tipo
    Optional<Status> findByStatusNameAndType(String statusName, String type);

    //obtener todos los status
    List<Status> findAll();

    //obtener status por tipo
    List<Status> findByType(String type);

    //guardar o actualizar status
    Status save(Status status);
}

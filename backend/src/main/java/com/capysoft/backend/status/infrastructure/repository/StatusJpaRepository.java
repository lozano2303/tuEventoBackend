package com.capysoft.backend.status.infrastructure.repository;

import java.util.List;

import com.capysoft.backend.status.domain.model.Status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusJpaRepository extends JpaRepository<Status, Integer> {

    // Método para encontrar un estado por su nombre y tipo por ej, activo / usuario
    Optional<Status> findByStatusNameAndType(String statusName, String type);

    // Método para encontrar todos los estados de un tipo específico
    List<Status> findByType(String type);

}

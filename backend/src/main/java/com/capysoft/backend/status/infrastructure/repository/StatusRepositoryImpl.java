package com.capysoft.backend.status.infrastructure.repository;

import com.capysoft.backend.status.domain.model.Status;
import com.capysoft.backend.status.domain.repository.IStatusRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StatusRepositoryImpl implements IStatusRepository {

    private final StatusJpaRepository statusJpaRepository;

    public StatusRepositoryImpl(StatusJpaRepository statusJpaRepository) {
        this.statusJpaRepository = statusJpaRepository;
    }

    @Override
    public Optional<Status> findById(int statusId) {
        return statusJpaRepository.findById(statusId);
    }

    @Override
    public Optional<Status> findByStatusNameAndType(String statusName, String type) {
        return statusJpaRepository.findByStatusNameAndType(statusName, type);
    }

    @Override
    public List<Status> findAll() {
        return statusJpaRepository.findAll();
    }

    @Override
    public List<Status> findByType(String type) {
        return statusJpaRepository.findByType(type);
    }

    @Override
    public Status save(Status status) {
        return statusJpaRepository.save(status);
    }
}

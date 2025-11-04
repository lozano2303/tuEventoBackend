package com.capysoft.backend.status.application.service;

import com.capysoft.backend.status.domain.model.Status;
import com.capysoft.backend.status.domain.repository.IStatusRepository;
import com.capysoft.backend.status.domain.service.IStatusService;
import com.capysoft.backend.status.application.mapper.StatusMapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.capysoft.backend.status.application.dto.StatusRequestDTO;
import com.capysoft.backend.status.application.dto.StatusResponseDTO;

@Service
public class StatusServiceImpl implements IStatusService {

    private final IStatusRepository statusRepository;
    private final StatusMapper statusMapper;

    //contructor inyeccion de dependencias
    public StatusServiceImpl(IStatusRepository statusRepository, StatusMapper statusMapper) {
        this.statusRepository = statusRepository;
        this.statusMapper = statusMapper;
    }

    @Override
    public StatusResponseDTO create(StatusRequestDTO dto){
        Status status = statusMapper.toEntity(dto);
        Status savedStatus = statusRepository.save(status);
        return statusMapper.toResponseDTO(savedStatus);
    }

    @Override
    public List<StatusResponseDTO> getAll(){
        return statusRepository.findAll()
                .stream()
                .map(statusMapper::toResponseDTO)
                .collect((Collectors.toList()));
    }

    @Override
    public StatusResponseDTO getById(int statusId){
        return statusRepository.findById(statusId)
                .map(statusMapper::toResponseDTO)
                .orElse(null);
    }

    @Override
    public List<StatusResponseDTO> getByType(String type){
        return statusRepository.findByType(type)
                .stream()
                .map(statusMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}

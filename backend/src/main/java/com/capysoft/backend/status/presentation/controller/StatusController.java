package com.capysoft.backend.status.presentation.controller;

import com.capysoft.backend.status.domain.service.IStatusService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.capysoft.backend.status.application.dto.StatusRequestDTO;
import com.capysoft.backend.status.application.dto.StatusResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//Controlador REST para gestionar los estados
@RestController
@RequestMapping("/api/v2/statues")
public class StatusController {

    private final IStatusService statusService;

    public StatusController(IStatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping("/new")
    public ResponseEntity<StatusResponseDTO> createStatus(@RequestBody StatusRequestDTO dto){
        StatusResponseDTO createdStatus = statusService.create(dto);
        return ResponseEntity.ok(createdStatus);
    }

    @GetMapping("/all")
    public ResponseEntity<List<StatusResponseDTO>> getAll(){
        return ResponseEntity.ok(statusService.getAll());
    }

    @GetMapping("/{statusId}")
    public ResponseEntity<StatusResponseDTO> getById(@PathVariable int statusId){
        StatusResponseDTO found = statusService.getById(statusId);
        return found !=null ? ResponseEntity.ok(found) : ResponseEntity.notFound().build();
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<StatusResponseDTO>> getByType(@PathVariable String type){
        return ResponseEntity.ok(statusService.getByType(type));
    }
}

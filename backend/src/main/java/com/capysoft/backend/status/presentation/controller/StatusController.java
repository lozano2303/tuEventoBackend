package com.capysoft.backend.status.presentation.controller;

import com.capysoft.backend.status.application.dto.StatusRequestDTO;
import com.capysoft.backend.status.application.dto.StatusResponseDTO;
import com.capysoft.backend.status.domain.service.IStatusService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/statues")
@Tag(name = "Status Controller", description = "Endpoints para el manejo de estados")
public class StatusController {

    private final IStatusService statusService;

    public StatusController(IStatusService statusService) {
        this.statusService = statusService;
    }

    @Operation(summary = "Crear un nuevo estado", description = "Crea un nuevo estado en el sistema.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Estado creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping("/new")
    public ResponseEntity<StatusResponseDTO> createStatus(@RequestBody StatusRequestDTO dto){
        StatusResponseDTO createdStatus = statusService.create(dto);
        return ResponseEntity.ok(createdStatus);
    }

    @Operation(summary = "Listar todos los estados", description = "Obtiene una lista de todos los estados registrados.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista obtenida exitosamente")
    })
    @GetMapping("/all")
    public ResponseEntity<List<StatusResponseDTO>> getAll(){
        return ResponseEntity.ok(statusService.getAll());
    }

    @Operation(summary = "Buscar estado por ID", description = "Obtiene un estado por su identificador único.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Estado encontrado"),
        @ApiResponse(responseCode = "404", description = "Estado no encontrado")
    })
    @GetMapping("/{statusId}")
    public ResponseEntity<StatusResponseDTO> getById(@PathVariable int statusId){
        StatusResponseDTO found = statusService.getById(statusId);
        return found != null ? ResponseEntity.ok(found) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Buscar estados por tipo", description = "Obtiene una lista de estados filtrados por tipo.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Estados encontrados")
    })
    @GetMapping("/type/{type}")
    public ResponseEntity<List<StatusResponseDTO>> getByType(@PathVariable String type){
        return ResponseEntity.ok(statusService.getByType(type));
    }
}

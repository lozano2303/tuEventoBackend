package com.capysoft.backend.geolocation.presentation.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capysoft.backend.geolocation.application.dto.DepartmentRequestDTO;
import com.capysoft.backend.geolocation.application.dto.DepartmentResponseDTO;
import com.capysoft.backend.geolocation.domain.service.IDepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v2/departments")
@Tag(name = "Department Controller", description = "Endpoints para el manejo de los departamentos")
public class DepartmentController {
    
    private final IDepartmentService departmentService;

    public DepartmentController(IDepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @Operation(summary = "Crear un nuevo departamento" , description = "Crea un nuevo departamento en el sistema.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Departamento insertado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud invalida.")
    })
    @PostMapping("/new")
    public ResponseEntity<DepartmentResponseDTO> createDepartment (@RequestBody DepartmentRequestDTO dto){
        DepartmentResponseDTO createdDepartment = departmentService.create(dto);
        return ResponseEntity.ok(createdDepartment);
    }

    @Operation(summary = "Buscar departamento por Id" , description = "buscar un departamento especifico por Id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Departamento encontrado"),
        @ApiResponse(responseCode = "404", description = "Departamento no encontrado")
    })
    @GetMapping("{departmentId}")
    public ResponseEntity<DepartmentResponseDTO> getById(@PathVariable int departmentId){
        DepartmentResponseDTO found = departmentService.getById(departmentId);
        return found != null ? ResponseEntity.ok(found) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "buscar todos los departamentos" , description = "endpoint para buscar todos los departamentos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "departamentos encontrados")
    })
    @GetMapping("/all")
    public ResponseEntity<List<DepartmentResponseDTO>> getAll(){
        return ResponseEntity.ok(departmentService.getAll());
    }

    @Operation(summary = "Buscar por nombre", description = "endpoint para buscar departamento por nombre")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Departamento encontradoexitosamente"),
        @ApiResponse(responseCode = "404", description = "Departamento no encontrado")
    })
    @GetMapping("/name/{departmentName}")
    public ResponseEntity<List<DepartmentResponseDTO>> getByDepartmentName(@PathVariable String departmentName){
        List<DepartmentResponseDTO> foundNames = departmentService.getByDepartmentName(departmentName);
        return foundNames !=null ? ResponseEntity.ok(foundNames) : ResponseEntity.notFound().build();
    }

}

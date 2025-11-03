package com.capysoft.backend.user.presentation.controller;

import com.capysoft.backend.user.application.dto.RoleRequestDTO;
import com.capysoft.backend.user.application.dto.RoleResponseDTO;
import com.capysoft.backend.user.application.service.IRoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

// controlador REST para gestionar los roles de usuario
@Tag(name = "Role Controller", description = "Endpoints para la gestión de roles de usuario")
@RestController
@RequestMapping("/api/V2/roles")
public class RoleController {

    private final IRoleService roleService;

    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    // documentacion Swagger para el endpoint de creación de roles

    @Operation(summary = "Crear un nuevo rol", description = "Crea un nuevo rol de usuario en el sistema.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Rol creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })

    // endpoint para crear un nuevo rol (/api/V2/roles/new)
    @PostMapping("/new")
    public ResponseEntity<RoleResponseDTO> create(@RequestBody RoleRequestDTO dto){
        RoleResponseDTO response = roleService.createRole(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // documentacion Swagger para el endpoint de listar los roles

    @Operation(summary = "Listar todos los roles", description = "Obtiene una lista de todos los roles de usuario en el sistema.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de roles obtenida exitosamente")
    })

    // endpoint para listar todos los roles (/api/V2/roles/all)
    @GetMapping("/all")
    public ResponseEntity<List<RoleResponseDTO>> getAll(){
        List<RoleResponseDTO> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    // documentacion Swagger para el endpoint de buscar rol por nombre

    @Operation(summary = "Buscar rol por nombre", description = "Obtiene un rol de usuario por su nombre.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Rol obtenido exitosamente"),
        @ApiResponse(responseCode = "404", description = "Rol no encontrado")
    })

    // endpoint para buscar un rol por su nombre (/api/V2/roles/{name})
    @GetMapping("/{name}")
    public ResponseEntity<RoleResponseDTO> getByName(@PathVariable String name){
        RoleResponseDTO role = roleService.getRoleByName(name);
        return ResponseEntity.ok(role);
    }
}

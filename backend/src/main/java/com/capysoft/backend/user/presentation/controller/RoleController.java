package com.capysoft.backend.user.presentation.controller;

import com.capysoft.backend.user.application.dto.RoleRequestDTO;
import com.capysoft.backend.user.application.dto.RoleResponseDTO;
import com.capysoft.backend.user.application.service.IRoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/V2/roles")
public class RoleController {

    private final IRoleService roleService;

    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    // endpoint para crear un nuevo rol (/api/V2/roles/new)

    @PostMapping("/new")
    public ResponseEntity<RoleResponseDTO> create(@RequestBody RoleRequestDTO dto){
        RoleResponseDTO response = roleService.createRole(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // endpoint para listar todos los roles (/api/V2/roles/all)
    @GetMapping("/all")
    public ResponseEntity<List<RoleResponseDTO>> getAll(){
        List<RoleResponseDTO> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    // endpoint para buscar un rol por su nombre (/api/V2/roles/{name})
    @GetMapping("/{name}")
    public ResponseEntity<RoleResponseDTO> getByName(@PathVariable String name){
        RoleResponseDTO role = roleService.getRoleByName(name);
        return ResponseEntity.ok(role);
    }
}

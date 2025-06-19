package com.saludSystem.infrastructure.adapters.in.controllers;

import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.PaginatedResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public abstract class GenericController<DTO, ID, CREATE_DTO, UPDATE_DTO> {
    private final GenericService<DTO, ID, CREATE_DTO, UPDATE_DTO> genericService;

    protected GenericController(GenericService<DTO, ID, CREATE_DTO, UPDATE_DTO> genericService) {
        this.genericService = genericService;
    }

    @PostMapping("/Save")
    public ApiResponse create(@RequestBody CREATE_DTO dto) {
        return genericService.save(dto);
    }

    @GetMapping("/Get")
    public ResponseEntity<List<DTO>> getList() {
        return ResponseEntity.ok(genericService.getList()
        );
    }

    @GetMapping("Get/{id}")
    public DTO getById(@PathVariable ID id) {
        return genericService.getById(id);
    }

    @GetMapping("/GetAll")
    public ListResponse<DTO> getAllPaginated(
            @RequestParam UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "1") int page,
            @RequestParam(name = "Rows", defaultValue = "10") int rows) {
        return genericService.getAllPaginated(hospitalId, page, rows);
    }

    @PutMapping("Update/{id}")
    public ApiResponse update(@PathVariable ID id, @RequestBody UPDATE_DTO dto) {
        return genericService.update(id, dto);
    }

    @DeleteMapping("Delete/{id}")
    public ApiResponse delete(@PathVariable ID id) {
        return genericService.delete(id);
    }
}
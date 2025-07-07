package com.saludsystem.infrastructure.adapters.in.controllers;

import com.saludsystem.application.services.GenericService;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public abstract class GenericController<REQ, RES, ID> {

    private final GenericService<REQ, RES, ID> genericService;

    protected GenericController(GenericService<REQ, RES, ID> genericService) {
        this.genericService = genericService;
    }

    @PostMapping("/Save")
    public ApiResponse create(@RequestBody REQ dto) {
        return genericService.save(dto);
    }

    @GetMapping("/GetList")
    public ResponseEntity<List<RES>> getList() {
        return ResponseEntity.ok(genericService.getList()
        );
    }

    @GetMapping("GetById/{id}")
    public RES getById(@PathVariable ID id) {
        return genericService.getById(id);
    }

    @GetMapping("/GetAll")
    public ListResponse<RES> getAllPaginated(
            @RequestParam UUID hospitalId,
            @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return genericService.getAllPaginated(hospitalId, page, rows);
    }

    @PutMapping("Update/{id}")
    public ApiResponse update(@PathVariable ID id, @RequestBody REQ dto) {
        return genericService.update(id, dto);
    }

    @DeleteMapping("Delete/{id}")
    public ApiResponse delete(@PathVariable ID id) {
        return genericService.delete(id);
    }
}
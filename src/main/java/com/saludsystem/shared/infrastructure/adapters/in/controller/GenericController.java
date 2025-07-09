package com.saludsystem.shared.infrastructure.adapters.in.controller;

import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public abstract class GenericController<R, C, U, ID> {

    private final GenericService<R, C, U, ID> genericService;

    protected GenericController(GenericService<R, C, U, ID> genericService) {
        this.genericService = genericService;
    }

    @PostMapping("/Save")
    public ApiResponse create(@RequestBody C dto) {
        return genericService.save(dto);
    }

    @GetMapping("/GetList")
    public ResponseEntity<List<R>> getList() {
        return ResponseEntity.ok(genericService.getList()
        );
    }

    @GetMapping("GetById/{id}")
    public R getById(@PathVariable ID id) {
        return genericService.getById(id);
    }

    @GetMapping("/GetAll")
    public ListResponse<R> getAllPaginated(
            @RequestParam UUID hospitalId,
            @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return genericService.getAllPaginated(hospitalId, page, rows);
    }

    @PutMapping("Update/{id}")
    public ApiResponse update(@PathVariable ID id, @RequestBody U dto) {
        return genericService.update(id, dto);
    }

    @DeleteMapping("Delete/{id}")
    public ApiResponse delete(@PathVariable ID id) {
        return genericService.delete(id);
    }
}
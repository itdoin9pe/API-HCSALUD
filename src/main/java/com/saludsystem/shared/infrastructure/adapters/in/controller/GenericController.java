package com.saludsystem.shared.infrastructure.adapters.in.controller;

import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public abstract class GenericController<R, C, U, I> {

    private final GenericService<R, C, U, I> genericService;

    protected GenericController(GenericService<R, C, U, I> genericService) {
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
    public R getById(@PathVariable I id) {
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
    public ApiResponse update(@PathVariable I id, @RequestBody U dto) {
        return genericService.update(id, dto);
    }

    @DeleteMapping("Delete/{id}")
    public ApiResponse delete(@PathVariable I id) {
        return genericService.delete(id);
    }
}
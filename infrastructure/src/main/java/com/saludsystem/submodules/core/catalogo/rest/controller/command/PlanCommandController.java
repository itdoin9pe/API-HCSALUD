package com.saludsystem.submodules.core.catalogo.rest.controller.command;

import com.saludsystem.submodules.catalogo.command.create.PlanCreateHandler;
import com.saludsystem.submodules.catalogo.command.delete.PlanDeleteHandler;
import com.saludsystem.submodules.catalogo.command.edit.PlanEditHandler;
import com.saludsystem.submodules.catalogo.model.constant.PlanConstant;
import com.saludsystem.submodules.catalogo.model.dto.command.PlanCreateCommandDTO;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.PlanEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Planes")
@RestController
@RequestMapping("/api/Planes")
public class PlanCommandController {

    private final PlanCreateHandler createHandler;
    private final PlanEditHandler editHandler;
    private final PlanDeleteHandler deleteHandler;

    public PlanCommandController(PlanCreateHandler createHandler, PlanEditHandler editHandler, PlanDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody PlanCreateCommandDTO dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, PlanConstant.CREATED);
    }

    @PutMapping("/Update/{planId}")
    public ApiResponse update(@PathVariable UUID planId, @RequestBody PlanEditCommand dto) {
        editHandler.execute(planId, dto);
        return new ApiResponse(true, PlanConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{planId}")
    public ApiResponse delete(@PathVariable UUID planId) {
        deleteHandler.execute(planId);
        return new ApiResponse(true, PlanConstant.DELETED);
    }
}
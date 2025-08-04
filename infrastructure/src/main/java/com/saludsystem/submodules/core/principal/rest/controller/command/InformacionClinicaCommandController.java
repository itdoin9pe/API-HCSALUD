package com.saludsystem.submodules.core.principal.rest.controller.command;

import com.saludsystem.submodules.principal.command.create.InformacionClinicaCreateHandler;
import com.saludsystem.submodules.principal.command.delete.InformacionClinicaDeleteHandler;
import com.saludsystem.submodules.principal.command.edit.InformacionClinicaEditHandler;
import com.saludsystem.submodules.principal.model.constant.InformacionClinicaConstant;
import com.saludsystem.submodules.principal.model.dtos.command.InformacionClinicaCreateCommand;
import com.saludsystem.submodules.principal.model.dtos.edit.InformacionClinicaEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "InformacionClinicas")
@RestController
@RequestMapping("/api/InformacionClinicas")
public class InformacionClinicaCommandController {

    private final InformacionClinicaCreateHandler createHandler;
    private final InformacionClinicaEditHandler editHandler;
    private final InformacionClinicaDeleteHandler deleteHandler;

    public InformacionClinicaCommandController(InformacionClinicaCreateHandler createHandler, InformacionClinicaEditHandler editHandler, InformacionClinicaDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody InformacionClinicaCreateCommand dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, InformacionClinicaConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody InformacionClinicaEditCommand dto) {
        editHandler.execute(id, dto);
        return new ApiResponse(true, InformacionClinicaConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, InformacionClinicaConstant.DELETED);
    }

}
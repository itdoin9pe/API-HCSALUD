package com.saludsystem.submodules.core.operaciones.rest.controller.command;

import com.saludsystem.submodules.operaciones.command.create.PresentacionCreateHandler;
import com.saludsystem.submodules.operaciones.command.delete.PresentacionDeleteHandler;
import com.saludsystem.submodules.operaciones.command.edit.PresentacionEditHandler;
import com.saludsystem.submodules.operaciones.model.constant.PresentacionConstant;
import com.saludsystem.submodules.operaciones.model.dtos.command.PresentacionCreateCommand;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.PresentacionEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Presentaciones")
@RestController
@RequestMapping("/api/Presentaciones")
public class PresentacionCommandController {

    private final PresentacionCreateHandler createHandler;
    private final PresentacionEditHandler editHandler;
    private final PresentacionDeleteHandler deleteHandler;

    public PresentacionCommandController(PresentacionCreateHandler createHandler, PresentacionEditHandler editHandler, PresentacionDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody PresentacionCreateCommand createCommand) {
        createHandler.execute(createCommand);
        return new ApiResponse(true, PresentacionConstant.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody PresentacionEditCommand editCommand) {
        editHandler.execute(id, editCommand);
        return new ApiResponse(true, PresentacionConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        deleteHandler.execute(id);
        return new ApiResponse(true, PresentacionConstant.DELETED);
    }

}
package com.saludsystem.submodules.core.principal.rest.controller.command;

import com.saludsystem.submodules.principal.command.create.EstudioCreateHandler;
import com.saludsystem.submodules.principal.command.delete.EstudioDeleteHandler;
import com.saludsystem.submodules.principal.command.edit.EstudioEditHandler;
import com.saludsystem.submodules.principal.model.constant.EstudioConstant;
import com.saludsystem.submodules.principal.model.dtos.command.EstudioCreateCommand;
import com.saludsystem.submodules.principal.model.dtos.command.edit.EstudioEditCommand;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Estudios")
@RestController
@RequestMapping("/api/Estudios")
public class EstudioCommandController {

    private final EstudioCreateHandler createHandler;
    private final EstudioEditHandler editHandler;
    private final EstudioDeleteHandler deleteHandler;

    public EstudioCommandController(EstudioCreateHandler createHandler, EstudioEditHandler editHandler, EstudioDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping("/Save")
    public ApiResponse save(@RequestBody EstudioCreateCommand dto) {
        createHandler.execute(dto);
        return new ApiResponse(true, EstudioConstant.CREATED);
    }

    @PutMapping("/Update/{estudioId}")
    public ApiResponse update(@PathVariable UUID estudioId, @RequestBody EstudioEditCommand dto) {
        editHandler.execute(estudioId, dto);
        return new ApiResponse(true, EstudioConstant.UPDATED);
    }

    @DeleteMapping("/Delete/{estudioId}")
    public ApiResponse delete(@PathVariable UUID estudioId) {
        deleteHandler.execute(estudioId);
        return new ApiResponse(true, EstudioConstant.DELETED);
    }

}
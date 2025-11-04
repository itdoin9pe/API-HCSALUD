package com.saludsystem.submodules.core.configuracion.rest.controller.command;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.configuracion.command.create.PermisoCreateHandler;
import com.saludsystem.submodules.configuracion.command.delete.PermisoDeleteHandler;
import com.saludsystem.submodules.configuracion.command.edit.PermisoEditHandler;
import com.saludsystem.submodules.configuracion.model.constant.PermisoConstant;
import com.saludsystem.submodules.configuracion.model.dtos.command.PermisoCreateCommand;
import com.saludsystem.submodules.configuracion.model.dtos.command.edit.PermisoEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Permisos")
@RestController
@RequestMapping("/api/Permisos")
public class PermisoCommandController
{
	private final PermisoCreateHandler createHandler;
	private final PermisoEditHandler editHandler;
	private final PermisoDeleteHandler deleteHandler;

	public PermisoCommandController(
		PermisoCreateHandler createHandler,
		PermisoEditHandler editHandler,
		PermisoDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody PermisoCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, PermisoConstant.CREATED);
	}

	@PutMapping("/Update/{permisoId}")
	public ApiResponse update(@PathVariable UUID permisoId, @RequestBody PermisoEditCommand editCommand)
	{
		editHandler.execute(permisoId, editCommand);
		return new ApiResponse(true, PermisoConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{permisoId}")
	public ApiResponse delete(@PathVariable UUID permisoId)
	{
		deleteHandler.execute(permisoId);
		return new ApiResponse(true, PermisoConstant.DELETED);
	}
}
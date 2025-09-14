package com.saludsystem.submodules.core.configuracion.rest.controller.command;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.configuracion.command.create.RolCreateHandler;
import com.saludsystem.submodules.configuracion.command.delete.RolDeleteHandler;
import com.saludsystem.submodules.configuracion.command.edit.RolEditHandler;
import com.saludsystem.submodules.configuracion.model.constant.RolConstant;
import com.saludsystem.submodules.configuracion.model.dtos.command.RolCreateCommand;
import com.saludsystem.submodules.configuracion.model.dtos.command.edit.RolEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Roles")
@RestController
@RequestMapping("/api/Roles")
public class RoleCommandController
{
	private final RolCreateHandler createHandler;
	private final RolEditHandler editHandler;
	private final RolDeleteHandler deleteHandler;

	public RoleCommandController(
		RolCreateHandler createHandler,
		RolEditHandler editHandler,
		RolDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody RolCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, RolConstant.CREATED);
	}

	@PutMapping("/UpdateRol/{roleId}")
	public ApiResponse update(@PathVariable UUID roleId, @RequestBody RolEditCommand editCommand)
	{
		editHandler.execute(roleId, editCommand);
		return new ApiResponse(true, RolConstant.UPDATED);
	}

	@DeleteMapping("/DeleteRol/{roleId}")
	public ApiResponse destroy(@PathVariable UUID roleId)
	{
		deleteHandler.execute(roleId);
		return new ApiResponse(true, RolConstant.DELETED);
	}
}
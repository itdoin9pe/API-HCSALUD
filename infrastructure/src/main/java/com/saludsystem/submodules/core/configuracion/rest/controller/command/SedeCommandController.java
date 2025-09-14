package com.saludsystem.submodules.core.configuracion.rest.controller.command;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.configuracion.command.create.SedeCreateHandler;
import com.saludsystem.submodules.configuracion.command.delete.SedeDeleteHandler;
import com.saludsystem.submodules.configuracion.command.edit.SedeEditHandler;
import com.saludsystem.submodules.configuracion.model.constant.SedeConstant;
import com.saludsystem.submodules.configuracion.model.dtos.command.SedeCreateCommand;
import com.saludsystem.submodules.configuracion.model.dtos.command.edit.SedeEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Sedes")
@RestController
@RequestMapping("/api/Sedes")
public class SedeCommandController
{
	private final SedeCreateHandler createHandler;
	private final SedeEditHandler editHandler;
	private final SedeDeleteHandler deleteHandler;

	public SedeCommandController(
		SedeCreateHandler createHandler,
		SedeEditHandler editHandler,
		SedeDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody SedeCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, SedeConstant.CREATED);
	}

	@PutMapping("/Update/{sedeId}")
	public ApiResponse update(@PathVariable UUID sedeId, @RequestBody SedeEditCommand editCommand)
	{
		editHandler.execute(sedeId, editCommand);
		return new ApiResponse(true, SedeConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{sedeId}")
	public ApiResponse destroy(@PathVariable UUID sedeId)
	{
		deleteHandler.execute(sedeId);
		return new ApiResponse(true, SedeConstant.DELETED);
	}
}
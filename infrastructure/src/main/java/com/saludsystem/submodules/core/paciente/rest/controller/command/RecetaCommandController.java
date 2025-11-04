package com.saludsystem.submodules.core.paciente.rest.controller.command;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.command.create.RecetaCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.RecetaDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.RecetaEditHandler;
import com.saludsystem.submodules.paciente.model.constant.RecetaConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.RecetaCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.RecetaEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesRecetas")
@RestController
@RequestMapping("/api/Pacientes/Recetas")
public class RecetaCommandController
{
	private final RecetaCreateHandler createHandler;
	private final RecetaEditHandler editHandler;
	private final RecetaDeleteHandler deleteHandler;

	public RecetaCommandController(
		RecetaCreateHandler createHandler,
		RecetaEditHandler editHandler,
		RecetaDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody RecetaCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, RecetaConstant.CREATED);
	}

	@PutMapping("/Update/{id}")
	public ApiResponse update(@PathVariable UUID id, @RequestBody RecetaEditCommand editCommand)
	{
		editHandler.execute(id, editCommand);
		return new ApiResponse(true, RecetaConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{id}")
	public ApiResponse delete(@PathVariable UUID id)
	{
		deleteHandler.execute(id);
		return new ApiResponse(true, RecetaConstant.DELETED);
	}
}

package com.saludsystem.submodules.core.operaciones.rest.controller.command;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.operaciones.command.create.UnidadCreateHandler;
import com.saludsystem.submodules.operaciones.command.delete.UnidadDeleteHandler;
import com.saludsystem.submodules.operaciones.command.edit.UnidadEditHandler;
import com.saludsystem.submodules.operaciones.model.constant.UnidadConstant;
import com.saludsystem.submodules.operaciones.model.dtos.command.UnidadCreateCommand;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.UnidadEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Unidades")
@RestController
@RequestMapping("/api/Unidades")
public class UnidadCommandController
{
	private final UnidadCreateHandler createHandler;
	private final UnidadEditHandler editHandler;
	private final UnidadDeleteHandler deleteHandler;

	public UnidadCommandController(
		UnidadCreateHandler createHandler,
		UnidadEditHandler editHandler,
		UnidadDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody UnidadCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, UnidadConstant.CREATED);
	}

	@PutMapping("/Update/{unidadId}")
	public ApiResponse update(@PathVariable UUID unidadId, @RequestBody UnidadEditCommand editCommand)
	{
		editHandler.execute(unidadId, editCommand);
		return new ApiResponse(true, UnidadConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{unidadId}")
	public ApiResponse delete(@PathVariable UUID unidadId)
	{
		deleteHandler.execute(unidadId);
		return new ApiResponse(true, UnidadConstant.DELETED);
	}
}
package com.saludsystem.submodules.core.operaciones.rest.controller.command;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.operaciones.command.create.MarcaCreateHandler;
import com.saludsystem.submodules.operaciones.command.delete.MarcaDeleteHandler;
import com.saludsystem.submodules.operaciones.command.edit.MarcaEditHandler;
import com.saludsystem.submodules.operaciones.model.constant.MarcaConstant;
import com.saludsystem.submodules.operaciones.model.dtos.command.MarcaCreateCommand;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.MarcaEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "MarcasMateriales")
@RestController
@RequestMapping("/api/MarcasMateriales")
public class MarcaCommandController
{
	private final MarcaCreateHandler createHandler;
	private final MarcaEditHandler editHandler;
	private final MarcaDeleteHandler deleteHandler;

	public MarcaCommandController(
		MarcaCreateHandler createHandler,
		MarcaEditHandler editHandler,
		MarcaDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody MarcaCreateCommand dto)
	{
		createHandler.execute(dto);
		return new ApiResponse(true, MarcaConstant.CREATED);
	}

	@PutMapping("/Update/{marcaId}")
	public ApiResponse update(@PathVariable UUID marcaId, @RequestBody MarcaEditCommand dto)
	{
		editHandler.execute(marcaId, dto);
		return new ApiResponse(true, MarcaConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{marcaId}")
	public ApiResponse delete(@PathVariable UUID marcaId)
	{
		deleteHandler.execute(marcaId);
		return new ApiResponse(true, MarcaConstant.DELETED);
	}
}
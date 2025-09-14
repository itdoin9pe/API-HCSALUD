package com.saludsystem.submodules.core.movimiento.rest.controller.command;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.movimiento.command.create.AlmacenCreateHandler;
import com.saludsystem.submodules.movimiento.command.delete.AlmacenDeleteHandler;
import com.saludsystem.submodules.movimiento.command.edit.AlmacenEditHandler;
import com.saludsystem.submodules.movimiento.model.constant.AlmacenConstant;
import com.saludsystem.submodules.movimiento.model.dtos.command.AlmacenCreateCommand;
import com.saludsystem.submodules.movimiento.model.dtos.command.edit.AlmacenEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Almacenes")
@RestController
@RequestMapping("/api/Almacenes")
public class AlmacenCommandController
{
	private final AlmacenCreateHandler createHandler;
	private final AlmacenEditHandler editHandler;
	private final AlmacenDeleteHandler deleteHandler;

	public AlmacenCommandController(
		AlmacenCreateHandler createHandler,
		AlmacenEditHandler editHandler,
		AlmacenDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody AlmacenCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, AlmacenConstant.CREATED);
	}

	@PutMapping("/Update/{almacenId}")
	public ApiResponse update(@PathVariable UUID almacenId, @RequestBody AlmacenEditCommand editCommand)
	{
		editHandler.execute(almacenId, editCommand);
		return new ApiResponse(true, AlmacenConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{almacenId}")
	public ApiResponse delete(@PathVariable UUID almacenId)
	{
		deleteHandler.execute(almacenId);
		return new ApiResponse(true, AlmacenConstant.DELETED);
	}
}
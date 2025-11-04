package com.saludsystem.submodules.core.movimiento.rest.controller.command;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.movimiento.command.create.InventarioCreateHandler;
import com.saludsystem.submodules.movimiento.command.delete.InventarioDeleteHandler;
import com.saludsystem.submodules.movimiento.command.edit.InventarioEditHandler;
import com.saludsystem.submodules.movimiento.model.constant.InventarioConstant;
import com.saludsystem.submodules.movimiento.model.dtos.command.InventarioCreateCommand;
import com.saludsystem.submodules.movimiento.model.dtos.command.edit.InventarioEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Inventarios")
@RestController
@RequestMapping("/api/Inventarios")
public class InventarioCommandController
{
	private final InventarioCreateHandler createHandler;
	private final InventarioEditHandler editHandler;
	private final InventarioDeleteHandler deleteHandler;

	public InventarioCommandController(
		InventarioCreateHandler createHandler,
		InventarioEditHandler editHandler,
		InventarioDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody InventarioCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, InventarioConstant.CREATED);
	}

	@PutMapping("/Update/{inventarioId}")
	public ApiResponse update(@PathVariable UUID inventarioId, @RequestBody InventarioEditCommand editCommand)
	{
		editHandler.execute(inventarioId, editCommand);
		return new ApiResponse(true, InventarioConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{inventarioId}")
	public ApiResponse delete(@PathVariable UUID inventarioId)
	{
		deleteHandler.execute(inventarioId);
		return new ApiResponse(true, InventarioConstant.DELETED);
	}
}
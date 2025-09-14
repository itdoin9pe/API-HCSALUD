package com.saludsystem.submodules.core.movimiento.rest.controller.command;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.movimiento.command.create.CompraDetalleCreateHandler;
import com.saludsystem.submodules.movimiento.command.delete.CompraDetalleDeleteHandler;
import com.saludsystem.submodules.movimiento.command.edit.CompraDetalleEditHandler;
import com.saludsystem.submodules.movimiento.model.constant.CompraDetalleConstant;
import com.saludsystem.submodules.movimiento.model.dtos.command.CompraDetalleCreateCommand;
import com.saludsystem.submodules.movimiento.model.dtos.command.edit.CompraDetalleEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "ComprasDetalles")
@RestController
@RequestMapping("/api/ComprasDetalles")
public class CompraDetalleCommandController
{
	private final CompraDetalleCreateHandler createHandler;
	private final CompraDetalleEditHandler editHandler;
	private final CompraDetalleDeleteHandler deleteHandler;

	public CompraDetalleCommandController(
		CompraDetalleCreateHandler createHandler,
		CompraDetalleEditHandler editHandler,
		CompraDetalleDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody CompraDetalleCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, CompraDetalleConstant.CREATED);
	}

	@PutMapping("/Update/{compraDetalleId}")
	public ApiResponse update(@PathVariable UUID compraDetalleId, @RequestBody CompraDetalleEditCommand editCommand)
	{
		editHandler.execute(compraDetalleId, editCommand);
		return new ApiResponse(true, CompraDetalleConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{compraDetalleId}")
	public ApiResponse delete(@PathVariable UUID compraDetalleId)
	{
		deleteHandler.execute(compraDetalleId);
		return new ApiResponse(true, CompraDetalleConstant.DELETED);
	}
}
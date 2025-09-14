package com.saludsystem.submodules.core.movimiento.rest.controller.command;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.movimiento.command.create.VentaDetalleCreateHandler;
import com.saludsystem.submodules.movimiento.command.delete.VentaDetalleDeleteHandler;
import com.saludsystem.submodules.movimiento.command.edit.VentaDetalleEditHandler;
import com.saludsystem.submodules.movimiento.model.constant.VentaDetalleConstant;
import com.saludsystem.submodules.movimiento.model.dtos.command.VentaDetalleCreateCommand;
import com.saludsystem.submodules.movimiento.model.dtos.command.edit.VentaDetalleEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "VentasDetalles")
@RestController
@RequestMapping("/api/VentasDetalles")
public class VentaDetalleCommandContoller
{
	private final VentaDetalleCreateHandler createHandler;
	private final VentaDetalleEditHandler editHandler;
	private final VentaDetalleDeleteHandler deleteHandler;

	public VentaDetalleCommandContoller(
		VentaDetalleCreateHandler createHandler,
		VentaDetalleEditHandler editHandler,
		VentaDetalleDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody VentaDetalleCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, VentaDetalleConstant.CREATED);
	}

	@PutMapping("/Update/{ventaDetalleId}")
	public ApiResponse update(@PathVariable UUID ventaDetalleId, @RequestBody VentaDetalleEditCommand editCommand)
	{
		editHandler.execute(ventaDetalleId, editCommand);
		return new ApiResponse(true, VentaDetalleConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{ventaDetalleId}")
	public ApiResponse delete(@PathVariable UUID ventaDetalleId)
	{
		deleteHandler.execute(ventaDetalleId);
		return new ApiResponse(true, VentaDetalleConstant.DELETED);
	}
}
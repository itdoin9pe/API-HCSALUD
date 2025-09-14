package com.saludsystem.submodules.core.mantenimiento.rest.controller.command;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.mantenimiento.command.create.TipoTarjetaCreateHandler;
import com.saludsystem.submodules.mantenimiento.command.delete.TipoTarjetaDeleteHandler;
import com.saludsystem.submodules.mantenimiento.command.edit.TipoTarjetaEditHandler;
import com.saludsystem.submodules.mantenimiento.model.constant.TipoTarjetaConstant;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.TipoTarjetaCreateCommand;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.TipoTarjetaEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "TipoTarjeta")
@RestController
@RequestMapping("/api/TipoTarjeta")
public class TipoTarjetaCommandController
{
	private final TipoTarjetaCreateHandler createHandler;
	private final TipoTarjetaEditHandler editHandler;
	private final TipoTarjetaDeleteHandler deleteHandler;

	public TipoTarjetaCommandController(
		TipoTarjetaCreateHandler createHandler,
		TipoTarjetaEditHandler editHandler,
		TipoTarjetaDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody TipoTarjetaCreateCommand dto)
	{
		createHandler.execute(dto);
		return new ApiResponse(true, TipoTarjetaConstant.CREATED);
	}

	@PutMapping("/Update/{tipoTarjetaId}")
	public ApiResponse update(@PathVariable UUID tipoTarjetaId, @RequestBody TipoTarjetaEditCommand dto)
	{
		editHandler.execute(tipoTarjetaId, dto);
		return new ApiResponse(true, TipoTarjetaConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{tipoTarjetaId}")
	public ApiResponse delete(@PathVariable UUID tipoTarjetaId)
	{
		deleteHandler.execute(tipoTarjetaId);
		return new ApiResponse(true, TipoTarjetaConstant.DELETED);
	}
}
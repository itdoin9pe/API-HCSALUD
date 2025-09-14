package com.saludsystem.submodules.core.mantenimiento.rest.controller.command;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.catalogo.model.constant.AlergiaConstant;
import com.saludsystem.submodules.mantenimiento.command.create.MonedaCreateHandler;
import com.saludsystem.submodules.mantenimiento.command.delete.MonedaDeleteHandler;
import com.saludsystem.submodules.mantenimiento.command.edit.MonedaEditHandler;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.MonedaCreateCommand;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.MonedadEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "TiposMonedas")
@RestController
@RequestMapping("/api/TiposMonedas")
public class MonedaCommandController
{
	private final MonedaCreateHandler createHandler;
	private final MonedaEditHandler editHandler;
	private final MonedaDeleteHandler deleteHandler;

	public MonedaCommandController(
		MonedaCreateHandler createHandler,
		MonedaEditHandler editHandler,
		MonedaDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody MonedaCreateCommand dto)
	{
		createHandler.execute(dto);
		return new ApiResponse(true, AlergiaConstant.CREATED);
	}

	@PutMapping("/Update/{monedaId}")
	public ApiResponse update(@PathVariable UUID monedaId, @RequestBody MonedadEditCommand dto)
	{
		editHandler.execute(monedaId, dto);
		return new ApiResponse(true, AlergiaConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{monedaId}")
	public ApiResponse delete(@PathVariable UUID monedaId)
	{
		deleteHandler.execute(monedaId);
		return new ApiResponse(true, AlergiaConstant.DELETED);
	}
}
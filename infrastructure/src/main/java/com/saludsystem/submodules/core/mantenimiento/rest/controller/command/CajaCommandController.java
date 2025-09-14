package com.saludsystem.submodules.core.mantenimiento.rest.controller.command;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.mantenimiento.command.create.CajaCreateHandler;
import com.saludsystem.submodules.mantenimiento.command.delete.CajaDeleteHandler;
import com.saludsystem.submodules.mantenimiento.command.edit.CajaEditHandler;
import com.saludsystem.submodules.mantenimiento.model.constant.CajaConstant;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.CajaCreateCommand;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.CajaEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cajas")
@RestController
@RequestMapping("/api/Cajas")
public class CajaCommandController
{
	private final CajaCreateHandler createHandler;
	private final CajaEditHandler editHandler;
	private final CajaDeleteHandler deleteHandler;

	public CajaCommandController(
		CajaCreateHandler createHandler,
		CajaEditHandler editHandler,
		CajaDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody CajaCreateCommand dto)
	{
		createHandler.execute(dto);
		return new ApiResponse(true, CajaConstant.CREATED);
	}

	@PutMapping("/Update/{cajaId}")
	public ApiResponse update(@PathVariable UUID cajaId, @RequestBody CajaEditCommand dto)
	{
		editHandler.execute(cajaId, dto);
		return new ApiResponse(true, CajaConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{cajaId}")
	public ApiResponse delete(@PathVariable UUID cajaId)
	{
		deleteHandler.execute(cajaId);
		return new ApiResponse(true, CajaConstant.DELETED);
	}
}
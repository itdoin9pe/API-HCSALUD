package com.saludsystem.submodules.core.mantenimiento.rest.controller.command;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.mantenimiento.command.create.CuentaCreateHandler;
import com.saludsystem.submodules.mantenimiento.command.delete.CuentaDeleteHandler;
import com.saludsystem.submodules.mantenimiento.command.edit.CuentaEditHandler;
import com.saludsystem.submodules.mantenimiento.model.constant.CuentaConstant;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.CuentaCreateCommand;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.CuentaEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "CuentasPagar")
@RestController
@RequestMapping("/api/CuentasPagar")
public class CuentaCommandController
{
	private final CuentaCreateHandler createHandler;
	private final CuentaEditHandler editHandler;
	private final CuentaDeleteHandler deleteHandler;

	public CuentaCommandController(
		CuentaCreateHandler createHandler,
		CuentaEditHandler editHandler,
		CuentaDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody CuentaCreateCommand dto)
	{
		createHandler.execute(dto);
		return new ApiResponse(true, CuentaConstant.CREATED);
	}

	@PutMapping("/Update/{cuentaId}")
	public ApiResponse update(@PathVariable UUID cuentaId, @RequestBody CuentaEditCommand dto)
	{
		editHandler.execute(cuentaId, dto);
		return new ApiResponse(true, CuentaConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{cuentaId}")
	public ApiResponse delete(@PathVariable UUID cuentaId)
	{
		deleteHandler.execute(cuentaId);
		return new ApiResponse(true, CuentaConstant.DELETED);
	}
}
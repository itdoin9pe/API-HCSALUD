package com.saludsystem.submodules.core.mantenimiento.rest.controller.command;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.mantenimiento.command.create.TipoPagoCreateHandler;
import com.saludsystem.submodules.mantenimiento.command.delete.TipoPagoDeleteHandler;
import com.saludsystem.submodules.mantenimiento.command.edit.TipoPagoEditHandler;
import com.saludsystem.submodules.mantenimiento.model.constant.TipoPagoConstant;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.TipoPagoCreateCommand;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.TipoPagoEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "TiposPagos")
@RestController
@RequestMapping("/api/TiposPagos")
public class TipoPagoCommandController
{
	private final TipoPagoCreateHandler createHandler;
	private final TipoPagoEditHandler editHandler;
	private final TipoPagoDeleteHandler deleteHandler;

	public TipoPagoCommandController(
		TipoPagoCreateHandler createHandler,
		TipoPagoEditHandler editHandler,
		TipoPagoDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody TipoPagoCreateCommand dto)
	{
		createHandler.execute(dto);
		return new ApiResponse(true, TipoPagoConstant.CREATED);
	}

	@PutMapping("/Update/{tipoPagoId}")
	public ApiResponse update(@PathVariable UUID tipoPagoId, @RequestBody TipoPagoEditCommand dto)
	{
		editHandler.execute(tipoPagoId, dto);
		return new ApiResponse(true, TipoPagoConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{tipoPagoId}")
	public ApiResponse delete(@PathVariable UUID tipoPagoId)
	{
		deleteHandler.execute(tipoPagoId);
		return new ApiResponse(true, TipoPagoConstant.DELETED);
	}
}
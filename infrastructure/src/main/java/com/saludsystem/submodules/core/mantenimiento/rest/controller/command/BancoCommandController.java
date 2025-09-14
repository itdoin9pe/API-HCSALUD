package com.saludsystem.submodules.core.mantenimiento.rest.controller.command;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.mantenimiento.command.create.BancoCreateHandler;
import com.saludsystem.submodules.mantenimiento.command.delete.BancoDeleteHandler;
import com.saludsystem.submodules.mantenimiento.command.edit.BancoEditHandler;
import com.saludsystem.submodules.mantenimiento.model.constant.BancoConstant;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.BancoCreateCommand;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.BancoEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Bancos")
@RestController
@RequestMapping("/api/Bancos")
public class BancoCommandController
{
	private final BancoCreateHandler createHandler;
	private final BancoEditHandler editHandler;
	private final BancoDeleteHandler deleteHandler;

	public BancoCommandController(
		BancoCreateHandler createHandler,
		BancoEditHandler editHandler,
		BancoDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody BancoCreateCommand dto)
	{
		createHandler.execute(dto);
		return new ApiResponse(true, BancoConstant.CREATED);
	}

	@PutMapping("/Update/{bancoId}")
	public ApiResponse update(@PathVariable UUID bancoId, @RequestBody BancoEditCommand dto)
	{
		editHandler.execute(bancoId, dto);
		return new ApiResponse(true, BancoConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{bancoId}")
	public ApiResponse delete(@PathVariable UUID bancoId)
	{
		deleteHandler.execute(bancoId);
		return new ApiResponse(true, BancoConstant.DELETED);
	}
}
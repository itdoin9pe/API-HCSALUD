package com.saludsystem.submodules.core.catalogo.rest.controller.command;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.catalogo.command.create.ConsentimientoCreateHandler;
import com.saludsystem.submodules.catalogo.command.delete.ConsentimientoDeleteHandler;
import com.saludsystem.submodules.catalogo.command.edit.ConsentimientoEditHandler;
import com.saludsystem.submodules.catalogo.model.constant.ConsentimientoConstant;
import com.saludsystem.submodules.catalogo.model.dto.command.ConsentimientoCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.ConsentimientoEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Consentimientos")
@RestController
@RequestMapping("/api/Consentimientos")
public class ConsentimientoCommandController
{
	private final ConsentimientoCreateHandler createHandler;
	private final ConsentimientoEditHandler editHandler;
	private final ConsentimientoDeleteHandler deleteHandler;

	public ConsentimientoCommandController(
		ConsentimientoCreateHandler createHandler,
		ConsentimientoEditHandler editHandler,
		ConsentimientoDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody ConsentimientoCreateCommand dto)
	{
		createHandler.execute(dto);
		return new ApiResponse(true, ConsentimientoConstant.CREATED);
	}

	@PutMapping("/Update/{consentimientoId}")
	public ApiResponse update(@PathVariable UUID consentimientoId, @RequestBody ConsentimientoEditCommand dto)
	{
		editHandler.execute(consentimientoId, dto);
		return new ApiResponse(true, ConsentimientoConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{consentimientoId}")
	public ApiResponse delete(@PathVariable UUID consentimientoId)
	{
		deleteHandler.execute(consentimientoId);
		return new ApiResponse(true, ConsentimientoConstant.DELETED);
	}
}
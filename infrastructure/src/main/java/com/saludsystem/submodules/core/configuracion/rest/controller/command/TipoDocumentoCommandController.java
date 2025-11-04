package com.saludsystem.submodules.core.configuracion.rest.controller.command;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.configuracion.command.create.TipoDocumentoCreateHandler;
import com.saludsystem.submodules.configuracion.command.delete.TipoDocumentoDeleteHandler;
import com.saludsystem.submodules.configuracion.command.edit.TipoDocumentoEditHandler;
import com.saludsystem.submodules.configuracion.model.constant.TipoDocumentoConstant;
import com.saludsystem.submodules.configuracion.model.dtos.command.TipoDocumentoCreateCommand;
import com.saludsystem.submodules.configuracion.model.dtos.command.edit.TipoDocumentoEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "TipoDocumentos")
@RestController
@RequestMapping("/api/TipoDocumentos")
public class TipoDocumentoCommandController
{
	private final TipoDocumentoCreateHandler createHandler;
	private final TipoDocumentoEditHandler editHandler;
	private final TipoDocumentoDeleteHandler deleteHandler;

	public TipoDocumentoCommandController(
		TipoDocumentoCreateHandler createHandler,
		TipoDocumentoEditHandler editHandler,
		TipoDocumentoDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody TipoDocumentoCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, TipoDocumentoConstant.CREATED);
	}

	@PutMapping("/Update/{tipoDocumentoId}")
	public ApiResponse update(@PathVariable UUID tipoDocumentoId, @RequestBody TipoDocumentoEditCommand editCommand)
	{
		editHandler.execute(tipoDocumentoId, editCommand);
		return new ApiResponse(true, TipoDocumentoConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{tipoDocumentoId}")
	public ApiResponse delete(@PathVariable UUID tipoDocumentoId)
	{
		deleteHandler.execute(tipoDocumentoId);
		return new ApiResponse(true, TipoDocumentoConstant.DELETED);
	}
}
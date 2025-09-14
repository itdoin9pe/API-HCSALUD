package com.saludsystem.submodules.core.catalogo.rest.controller.command;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.catalogo.command.create.EspecialidadCreateHandler;
import com.saludsystem.submodules.catalogo.command.delete.EspecialidadDeleteHandler;
import com.saludsystem.submodules.catalogo.command.edit.EspecialidadEditHandler;
import com.saludsystem.submodules.catalogo.model.constant.EspecialidadConstant;
import com.saludsystem.submodules.catalogo.model.dto.command.EspecialidadCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.EspecialidadEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Especialidades")
@RestController
@RequestMapping("/api/Especialidades")
public class EspecialidadCommandController
{
	private final EspecialidadCreateHandler createHandler;
	private final EspecialidadEditHandler editHandler;
	private final EspecialidadDeleteHandler deleteHandler;

	public EspecialidadCommandController(
		EspecialidadCreateHandler createHandler,
		EspecialidadEditHandler editHandler,
		EspecialidadDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody EspecialidadCreateCommand dto)
	{
		createHandler.execute(dto);
		return new ApiResponse(true, EspecialidadConstant.CREATED);
	}

	@PutMapping("/Update/{especialidadId}")
	public ApiResponse update(@PathVariable UUID especialidadId, @RequestBody EspecialidadEditCommand dto)
	{
		editHandler.execute(especialidadId, dto);
		return new ApiResponse(true, EspecialidadConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{especialidadId}")
	public ApiResponse delete(@PathVariable UUID especialidadId)
	{
		deleteHandler.execute(especialidadId);
		return new ApiResponse(true, EspecialidadConstant.DELETED);
	}
}
package com.saludsystem.submodules.core.paciente.rest.controller.command.tratamiento;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.command.create.tratamiento.ProcedimientoCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.tratamiento.ProcedimientoDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.tratamiento.ProcedimientoEditHandler;
import com.saludsystem.submodules.paciente.model.constant.tratamiento.ProcedimientoConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.tratamiento.ProcedimientoCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.tratamiento.ProcedimientoEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesProcedimientos")
@RestController
@RequestMapping("/api/Pacientes/Procedimientos")
public class ProcedimientoCommandController
{
	private final ProcedimientoCreateHandler createHandler;
	private final ProcedimientoEditHandler editHandler;
	private final ProcedimientoDeleteHandler deleteHandler;

	public ProcedimientoCommandController(
		ProcedimientoCreateHandler createHandler,
		ProcedimientoEditHandler editHandler,
		ProcedimientoDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody ProcedimientoCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, ProcedimientoConstant.CREATED);
	}

	@PutMapping("/Update/{id}")
	public ApiResponse update(@PathVariable UUID id, @RequestBody ProcedimientoEditCommand editCommand)
	{
		editHandler.execute(id, editCommand);
		return new ApiResponse(true, ProcedimientoConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{id}")
	public ApiResponse delete(@PathVariable UUID id)
	{
		deleteHandler.execute(id);
		return new ApiResponse(true, ProcedimientoConstant.DELETED);
	}
}

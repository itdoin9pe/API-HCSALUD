package com.saludsystem.submodules.core.paciente.rest.controller.command.historialclinico;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.command.create.historialclinico.PacienteAlergiaCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.historialclinico.PacienteAlergiaDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.historialclinico.PacienteAlergiaEditHandler;
import com.saludsystem.submodules.paciente.model.constant.historialclinico.PacienteAlergiaConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.historialclinico.PacienteAlergiaCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.historialclinico.PacienteAlergiaEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesAlergias")
@RestController
@RequestMapping("/api/Pacientes/Alergias")
public class PacienteAlergiaCommandController
{
	private final PacienteAlergiaCreateHandler createHandler;
	private final PacienteAlergiaEditHandler editHandler;
	private final PacienteAlergiaDeleteHandler deleteHandler;

	public PacienteAlergiaCommandController(
		PacienteAlergiaCreateHandler createHandler,
		PacienteAlergiaEditHandler editHandler,
		PacienteAlergiaDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody PacienteAlergiaCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, PacienteAlergiaConstant.CREATED);
	}

	@PutMapping("/Update/{id}")
	public ApiResponse update(@PathVariable UUID id, @RequestBody PacienteAlergiaEditCommand editCommand)
	{
		editHandler.execute(id, editCommand);
		return new ApiResponse(true, PacienteAlergiaConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{id}")
	public ApiResponse delete(@PathVariable UUID id)
	{
		deleteHandler.execute(id);
		return new ApiResponse(true, PacienteAlergiaConstant.DELETED);
	}
}

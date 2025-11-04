package com.saludsystem.submodules.core.paciente.rest.controller.command.historialclinico;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.command.create.historialclinico.ConsultaCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.historialclinico.ConsultaDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.historialclinico.ConsultaEditHandler;
import com.saludsystem.submodules.paciente.model.constant.historialclinico.ConsultaConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.historialclinico.ConsultaCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.historialclinico.ConsultaEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesConsultas")
@RestController
@RequestMapping("/api/Pacientes/Consultas")
public class ConsultaCommandController
{
	private final ConsultaCreateHandler createHandler;
	private final ConsultaEditHandler editHandler;
	private final ConsultaDeleteHandler deleteHandler;

	public ConsultaCommandController(
		ConsultaCreateHandler createHandler,
		ConsultaEditHandler editHandler,
		ConsultaDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody ConsultaCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, ConsultaConstant.CREATED);
	}

	@PutMapping("/Update/{id}")
	public ApiResponse update(@PathVariable UUID id, @RequestBody ConsultaEditCommand editCommand)
	{
		editHandler.execute(id, editCommand);
		return new ApiResponse(true, ConsultaConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{id}")
	public ApiResponse delete(@PathVariable UUID id)
	{
		deleteHandler.execute(id);
		return new ApiResponse(true, ConsultaConstant.DELETED);
	}
}

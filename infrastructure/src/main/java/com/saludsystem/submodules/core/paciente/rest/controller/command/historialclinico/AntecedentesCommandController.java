package com.saludsystem.submodules.core.paciente.rest.controller.command.historialclinico;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.command.create.historialclinico.AntecedenteCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.historialclinico.AntecedenteDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.historialclinico.AntecedenteEditHandler;
import com.saludsystem.submodules.paciente.model.constant.historialclinico.AntecedenteConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.historialclinico.AntecedenteCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.historialclinico.AntecedenteEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesEnfermedadesActuales")
@RestController
@RequestMapping("/api/Pacientes/EnfermedadesActuales")
public class AntecedentesCommandController
{
	private final AntecedenteCreateHandler createHandler;
	private final AntecedenteEditHandler editHandler;
	private final AntecedenteDeleteHandler deleteHandler;

	public AntecedentesCommandController(
		AntecedenteCreateHandler createHandler,
		AntecedenteEditHandler editHandler,
		AntecedenteDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody AntecedenteCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, AntecedenteConstant.CREATED);
	}

	@PutMapping("/Update/{id}")
	public ApiResponse update(@PathVariable UUID id, @RequestBody AntecedenteEditCommand editCommand)
	{
		editHandler.execute(id, editCommand);
		return new ApiResponse(true, AntecedenteConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{id}")
	public ApiResponse delete(@PathVariable UUID id)
	{
		deleteHandler.execute(id);
		return new ApiResponse(true, AntecedenteConstant.DELETED);
	}
}

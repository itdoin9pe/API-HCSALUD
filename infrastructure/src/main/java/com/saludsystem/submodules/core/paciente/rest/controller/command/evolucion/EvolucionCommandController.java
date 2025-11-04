package com.saludsystem.submodules.core.paciente.rest.controller.command.evolucion;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.command.create.evolucion.EvolucionCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.evolucion.EvolucionDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.evolucion.EvolucionEditHandler;
import com.saludsystem.submodules.paciente.model.constant.evolucion.EvolucionConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.evolucion.EvolucionCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.evolucion.EvolucionEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesEvoluciones")
@RestController
@RequestMapping("/api/Pacientes/Evoluciones")
public class EvolucionCommandController
{
	private final EvolucionCreateHandler createHandler;
	private final EvolucionEditHandler editHandler;
	private final EvolucionDeleteHandler deleteHandler;

	public EvolucionCommandController(
		EvolucionCreateHandler createHandler,
		EvolucionEditHandler editHandler,
		EvolucionDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody EvolucionCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, EvolucionConstant.CREATED);
	}

	@PutMapping("/Update/{id}")
	public ApiResponse update(@PathVariable UUID id, @RequestBody EvolucionEditCommand editCommand)
	{
		editHandler.execute(id, editCommand);
		return new ApiResponse(true, EvolucionConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{id}")
	public ApiResponse delete(@PathVariable UUID id)
	{
		deleteHandler.execute(id);
		return new ApiResponse(true, EvolucionConstant.DELETED);
	}
}
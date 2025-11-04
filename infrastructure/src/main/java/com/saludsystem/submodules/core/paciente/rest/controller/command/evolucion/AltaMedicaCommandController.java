package com.saludsystem.submodules.core.paciente.rest.controller.command.evolucion;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.command.create.evolucion.AltaMedicaCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.evolucion.AltaMedicaDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.evolucion.AltaMedicaEditHandler;
import com.saludsystem.submodules.paciente.model.constant.evolucion.AltaMedicaConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.evolucion.AltaMedicaCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.evolucion.AltaMedicaEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesEvolucionesAltasMedicas")
@RestController
@RequestMapping("/api/Pacientes/Evoluciones/AltasMedicas")
public class AltaMedicaCommandController
{
	private final AltaMedicaCreateHandler createHandler;
	private final AltaMedicaEditHandler editHandler;
	private final AltaMedicaDeleteHandler deleteHandler;

	public AltaMedicaCommandController(
		AltaMedicaCreateHandler createHandler,
		AltaMedicaEditHandler editHandler,
		AltaMedicaDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody AltaMedicaCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, AltaMedicaConstant.CREATED);
	}

	@PutMapping("/Update/{id}")
	public ApiResponse update(@PathVariable Long id, @RequestBody AltaMedicaEditCommand editCommand)
	{
		editHandler.execute(id, editCommand);
		return new ApiResponse(true, AltaMedicaConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{id}")
	public ApiResponse delete(@PathVariable Long id)
	{
		deleteHandler.execute(id);
		return new ApiResponse(true, AltaMedicaConstant.DELETED);
	}
}

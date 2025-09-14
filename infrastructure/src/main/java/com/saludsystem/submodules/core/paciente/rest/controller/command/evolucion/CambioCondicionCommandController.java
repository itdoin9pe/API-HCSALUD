package com.saludsystem.submodules.core.paciente.rest.controller.command.evolucion;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.command.create.evolucion.CambioCondicionCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.evolucion.CambioCondicionDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.evolucion.CambioCondicionEditHandler;
import com.saludsystem.submodules.paciente.model.constant.evolucion.CambioCondicionConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.evolucion.CambioCondicionCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.evolucion.CambioCondicionEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesEvolucionesCambiosCondiciones")
@RestController
@RequestMapping("/api/Pacientes/Evoluciones/CambiosCondiciones")
public class CambioCondicionCommandController
{
	private final CambioCondicionCreateHandler createHandler;
	private final CambioCondicionEditHandler editHandler;
	private final CambioCondicionDeleteHandler deleteHandler;

	public CambioCondicionCommandController(
		CambioCondicionCreateHandler createHandler,
		CambioCondicionEditHandler editHandler,
		CambioCondicionDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody CambioCondicionCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, CambioCondicionConstant.CREATED);
	}

	@PutMapping("/Update/{id}")
	public ApiResponse update(@PathVariable Long id, @RequestBody CambioCondicionEditCommand editCommand)
	{
		editHandler.execute(id, editCommand);
		return new ApiResponse(true, CambioCondicionConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{id}")
	public ApiResponse delete(@PathVariable Long id)
	{
		deleteHandler.execute(id);
		return new ApiResponse(true, CambioCondicionConstant.DELETED);
	}
}

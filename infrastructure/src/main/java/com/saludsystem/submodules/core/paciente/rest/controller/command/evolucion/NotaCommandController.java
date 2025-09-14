package com.saludsystem.submodules.core.paciente.rest.controller.command.evolucion;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.command.create.evolucion.NotaCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.evolucion.NotaDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.evolucion.NotaEditHandler;
import com.saludsystem.submodules.paciente.model.constant.evolucion.NotaConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.evolucion.NotaCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.evolucion.NotaEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesEvolucionesNotas")
@RestController
@RequestMapping("/api/Pacientes/Evololuciones/Notas")
public class NotaCommandController
{
	private final NotaCreateHandler createHandler;
	private final NotaEditHandler editHandler;
	private final NotaDeleteHandler deleteHandler;

	public NotaCommandController(
		NotaCreateHandler createHandler,
		NotaEditHandler editHandler,
		NotaDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody NotaCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, NotaConstant.CREATED);
	}

	@PutMapping("/Update/{id}")
	public ApiResponse update(@PathVariable Long id, @RequestBody NotaEditCommand editCommand)
	{
		editHandler.execute(id, editCommand);
		return new ApiResponse(true, NotaConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{id}")
	public ApiResponse delete(@PathVariable Long id)
	{
		deleteHandler.execute(id);
		return new ApiResponse(true, NotaConstant.DELETED);
	}
}

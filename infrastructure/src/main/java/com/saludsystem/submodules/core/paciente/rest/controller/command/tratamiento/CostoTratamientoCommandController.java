package com.saludsystem.submodules.core.paciente.rest.controller.command.tratamiento;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.command.create.tratamiento.CostoTratamientoCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.tratamiento.CostoTratamientoDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.tratamiento.CostoTratamientoEditHandler;
import com.saludsystem.submodules.paciente.model.constant.tratamiento.CostoTratamientoConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.tratamiento.CostoTratamientoCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.tratamiento.CostoTratamientoEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesCostosTratamientos")
@RestController
@RequestMapping("/api/Pacientes/CostosTratamientos")
public class CostoTratamientoCommandController
{
	private final CostoTratamientoCreateHandler createHandler;
	private final CostoTratamientoEditHandler editHandler;
	private final CostoTratamientoDeleteHandler deleteHandler;

	public CostoTratamientoCommandController(
		CostoTratamientoCreateHandler createHandler,
		CostoTratamientoEditHandler editHandler,
		CostoTratamientoDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody CostoTratamientoCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, CostoTratamientoConstant.CREATED);
	}

	@PutMapping("/Update/{id}")
	public ApiResponse update(@PathVariable UUID id, @RequestBody CostoTratamientoEditCommand editCommand)
	{
		editHandler.execute(id, editCommand);
		return new ApiResponse(true, CostoTratamientoConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{id}")
	public ApiResponse delete(@PathVariable UUID id)
	{
		deleteHandler.execute(id);
		return new ApiResponse(true, CostoTratamientoConstant.DELETED);
	}
}

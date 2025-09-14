package com.saludsystem.submodules.core.paciente.rest.controller.command.estadocuenta;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.command.create.estadocuenta.EstadoCuentaCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.estadocuenta.EstadoCuentaDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.estadocuenta.EstadoCuentaEditHandler;
import com.saludsystem.submodules.paciente.model.constant.estadocuenta.EstadoCuentaConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.estadocuenta.EstadoCuentaCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.estadocuenta.EstadoCuentaEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesEstadosCuentas")
@RestController
@RequestMapping("/api/Pacientes/EstadosCuentas")
public class EstadoCuentaCommandController
{
	private final EstadoCuentaCreateHandler createHandler;
	private final EstadoCuentaEditHandler editHandler;
	private final EstadoCuentaDeleteHandler deleteHandler;

	public EstadoCuentaCommandController(
		EstadoCuentaCreateHandler createHandler,
		EstadoCuentaEditHandler editHandler,
		EstadoCuentaDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody EstadoCuentaCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, EstadoCuentaConstant.CREATED);
	}

	@PutMapping("/Update/{id}")
	public ApiResponse update(@PathVariable UUID id, @RequestBody EstadoCuentaEditCommand editCommand)
	{
		editHandler.execute(id, editCommand);
		return new ApiResponse(true, EstadoCuentaConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{id}")
	public ApiResponse delete(@PathVariable UUID id)
	{
		deleteHandler.execute(id);
		return new ApiResponse(true, EstadoCuentaConstant.DELETED);
	}
}

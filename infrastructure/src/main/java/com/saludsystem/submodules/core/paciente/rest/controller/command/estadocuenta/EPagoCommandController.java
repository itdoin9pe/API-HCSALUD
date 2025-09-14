package com.saludsystem.submodules.core.paciente.rest.controller.command.estadocuenta;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.command.create.estadocuenta.EPagoCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.estadocuenta.EPagoDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.estadocuenta.EPagoEditHandler;
import com.saludsystem.submodules.paciente.model.constant.estadocuenta.EPagoConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.estadocuenta.EPagoCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.estadocuenta.EPagoEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesEstadosCuentasPagos")
@RestController
@RequestMapping("/api/Pacientes/EstadosCuentas/Pagos")
public class EPagoCommandController
{
	private final EPagoCreateHandler createHandler;
	private final EPagoEditHandler editHandler;
	private final EPagoDeleteHandler deleteHandler;

	public EPagoCommandController(
		EPagoCreateHandler createHandler,
		EPagoEditHandler editHandler,
		EPagoDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody EPagoCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, EPagoConstant.CREATED);
	}

	@PutMapping("/Update/{id}")
	public ApiResponse update(@PathVariable UUID id, @RequestBody EPagoEditCommand editCommand)
	{
		editHandler.execute(id, editCommand);
		return new ApiResponse(true, EPagoConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{id}")
	public ApiResponse delete(@PathVariable UUID id)
	{
		deleteHandler.execute(id);
		return new ApiResponse(true, EPagoConstant.DELETED);
	}
}

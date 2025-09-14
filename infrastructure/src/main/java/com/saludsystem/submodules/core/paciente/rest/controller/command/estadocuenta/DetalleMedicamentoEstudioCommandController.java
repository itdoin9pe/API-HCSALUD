package com.saludsystem.submodules.core.paciente.rest.controller.command.estadocuenta;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.command.create.estadocuenta.DetalleMedicamentoEstudioCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.estadocuenta.DetalleMedicamentoEstudioDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.estadocuenta.DetalleMedicamentoEstudioEditHandler;
import com.saludsystem.submodules.paciente.model.constant.estadocuenta.DetalleMedicamentoEstudioConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.estadocuenta.DetalleMedicamentoEstudioCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.estadocuenta.DetalleMedicamentoEstudioEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesEstadosCuentasEstudiosDetallesMedicamentos")
@RestController
@RequestMapping("/api/Pacientes/EstadosCuentas/EstudiosDetallesMedicamentos")
public class DetalleMedicamentoEstudioCommandController
{
	private final DetalleMedicamentoEstudioCreateHandler createHandler;
	private final DetalleMedicamentoEstudioEditHandler editHandler;
	private final DetalleMedicamentoEstudioDeleteHandler deleteHandler;

	public DetalleMedicamentoEstudioCommandController(
		DetalleMedicamentoEstudioCreateHandler createHandler,
		DetalleMedicamentoEstudioEditHandler editHandler,
		DetalleMedicamentoEstudioDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody DetalleMedicamentoEstudioCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, DetalleMedicamentoEstudioConstant.CREATED);
	}

	@PutMapping("/Update/{id}")
	public ApiResponse update(@PathVariable UUID id, @RequestBody DetalleMedicamentoEstudioEditCommand editCommand)
	{
		editHandler.execute(id, editCommand);
		return new ApiResponse(true, DetalleMedicamentoEstudioConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{id}")
	public ApiResponse delete(@PathVariable UUID id)
	{
		deleteHandler.execute(id);
		return new ApiResponse(true, DetalleMedicamentoEstudioConstant.DELETED);
	}
}

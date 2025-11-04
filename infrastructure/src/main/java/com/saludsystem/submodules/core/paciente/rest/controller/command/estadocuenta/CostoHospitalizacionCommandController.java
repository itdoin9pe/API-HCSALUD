package com.saludsystem.submodules.core.paciente.rest.controller.command.estadocuenta;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.command.create.estadocuenta.CostoHospitalizacionCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.estadocuenta.CostoHospitalizacionDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.estadocuenta.CostoHospitalizacionEditHandler;
import com.saludsystem.submodules.paciente.model.constant.estadocuenta.CostoHospitalizacionConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.estadocuenta.CostoHospitalizacionCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.estadocuenta.CostoHospitalizacionEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesEstadosCuentasCostosHospitalizaciones")
@RestController
@RequestMapping("/api/Pacientes/EstadosCuentas/CostosHospitalizaciones")
public class CostoHospitalizacionCommandController
{
	private final CostoHospitalizacionCreateHandler createHandler;
	private final CostoHospitalizacionEditHandler editHandler;
	private final CostoHospitalizacionDeleteHandler deleteHandler;

	public CostoHospitalizacionCommandController(
		CostoHospitalizacionCreateHandler createHandler,
		CostoHospitalizacionEditHandler editHandler,
		CostoHospitalizacionDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody CostoHospitalizacionCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, CostoHospitalizacionConstant.CREATED);
	}

	@PutMapping("/Update/{id}")
	public ApiResponse update(@PathVariable UUID id, @RequestBody CostoHospitalizacionEditCommand editCommand)
	{
		editHandler.execute(id, editCommand);
		return new ApiResponse(true, CostoHospitalizacionConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{id}")
	public ApiResponse delete(@PathVariable UUID id)
	{
		deleteHandler.execute(id);
		return new ApiResponse(true, CostoHospitalizacionConstant.DELETED);
	}
}

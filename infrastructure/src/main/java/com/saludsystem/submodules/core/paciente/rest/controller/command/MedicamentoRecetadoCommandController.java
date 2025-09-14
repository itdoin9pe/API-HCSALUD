package com.saludsystem.submodules.core.paciente.rest.controller.command;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.command.create.MedicamentoRecetadoCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.MedicamentoRecetadoDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.MedicamentoRecetadoEditHandler;
import com.saludsystem.submodules.paciente.model.constant.MedicamentoRecetadoConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.MedicamentoRecetadoCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.MedicamentoRecetadoEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesMedicamentosRecetados")
@RestController
@RequestMapping("/api/Pacientes/MedicamentosRecetados")
public class MedicamentoRecetadoCommandController
{
	private final MedicamentoRecetadoCreateHandler createHandler;
	private final MedicamentoRecetadoEditHandler editHandler;
	private final MedicamentoRecetadoDeleteHandler deleteHandler;

	public MedicamentoRecetadoCommandController(
		MedicamentoRecetadoCreateHandler createHandler,
		MedicamentoRecetadoEditHandler editHandler,
		MedicamentoRecetadoDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody MedicamentoRecetadoCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, MedicamentoRecetadoConstant.CREATED);
	}

	@PutMapping("/Update/{id}")
	public ApiResponse update(@PathVariable UUID id, @RequestBody MedicamentoRecetadoEditCommand editCommand)
	{
		editHandler.execute(id, editCommand);
		return new ApiResponse(true, MedicamentoRecetadoConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{id}")
	public ApiResponse delete(@PathVariable UUID id)
	{
		deleteHandler.execute(id);
		return new ApiResponse(true, MedicamentoRecetadoConstant.DELETED);
	}
}

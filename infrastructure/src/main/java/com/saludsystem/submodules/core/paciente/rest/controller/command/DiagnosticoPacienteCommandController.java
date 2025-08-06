package com.saludsystem.submodules.core.paciente.rest.controller.command;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.saludsystem.submodules.paciente.command.create.DiagnosticoCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.DiagnosticoDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.DiagnosticoEditHandler;
import com.saludsystem.submodules.paciente.model.constant.DiagnosticoConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.DiagnosticoCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.DiagnosticoEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

@Tag(name = "PacientesDiagnosticos")
@RestController
@RequestMapping("/api/Pacientes/Diagnosticos")
public class DiagnosticoPacienteCommandController {

	private final DiagnosticoCreateHandler createHandler;
	private final DiagnosticoEditHandler editHandler;
	private final DiagnosticoDeleteHandler deleteHandler;
	
	/**
	 * @param createHandler
	 * @param editHandler
	 * @param deleteHandler
	 */
	public DiagnosticoPacienteCommandController(DiagnosticoCreateHandler createHandler,
			DiagnosticoEditHandler editHandler, DiagnosticoDeleteHandler deleteHandler) {
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}
	
	 @PostMapping("/Save")
	    public ApiResponse save(@RequestBody DiagnosticoCreateCommand createCommand) {
	        createHandler.execute(createCommand);
	        return new ApiResponse(true, DiagnosticoConstant.CREATED);
	    }

	    @PutMapping("/Update/{id}")
	    public ApiResponse update(@PathVariable UUID id, @RequestBody DiagnosticoEditCommand editCommand) {
	        editHandler.execute(id, editCommand);
	        return new ApiResponse(true, DiagnosticoConstant.UPDATED);
	    }

	    @DeleteMapping("/Delete/{id}")
	    public ApiResponse delete(@PathVariable UUID id) {
	        deleteHandler.execute(id);
	        return new ApiResponse(true, DiagnosticoConstant.DELETED);
	    }

}
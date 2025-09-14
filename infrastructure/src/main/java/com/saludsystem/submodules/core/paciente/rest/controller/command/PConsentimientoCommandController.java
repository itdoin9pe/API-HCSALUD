package com.saludsystem.submodules.core.paciente.rest.controller.command;

import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.command.create.PConsentimientoCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.PConsentimientoDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.PConsentimientoEditHandler;
import com.saludsystem.submodules.paciente.model.constant.PConsentimientoConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.PConsentimientoCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.PConsentimientoEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesConsentimientos")
@RestController
@RequestMapping("/api/Pacientes/Consentimientos")
public class PConsentimientoCommandController
{
	private final PConsentimientoCreateHandler createHandler;
	private final PConsentimientoEditHandler editHandler;
	private final PConsentimientoDeleteHandler deleteHandler;

	public PConsentimientoCommandController(
		PConsentimientoCreateHandler createHandler,
		PConsentimientoEditHandler editHandler,
		PConsentimientoDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
	@PostMapping(value = "/Save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ApiResponse save(@RequestBody PConsentimientoCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, PConsentimientoConstant.CREATED);
	}

	@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
	@PutMapping(value = "/Update/{Id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ApiResponse update(@PathVariable UUID id, @RequestBody PConsentimientoEditCommand editCommand)
	{
		editHandler.execute(id, editCommand);
		return new ApiResponse(true, PConsentimientoConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{Id}")
	public ApiResponse destroy(@PathVariable UUID doctorId)
	{
		deleteHandler.execute(doctorId);
		return new ApiResponse(true, PConsentimientoConstant.DELETED);
	}
}

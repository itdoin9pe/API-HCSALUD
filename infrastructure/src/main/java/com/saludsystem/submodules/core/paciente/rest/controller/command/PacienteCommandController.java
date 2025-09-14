package com.saludsystem.submodules.core.paciente.rest.controller.command;

import java.io.IOException;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saludsystem.submodules.FileStorageService;
import com.saludsystem.submodules.paciente.command.create.PacienteCreateHandler;
import com.saludsystem.submodules.paciente.command.delete.PacienteDeleteHandler;
import com.saludsystem.submodules.paciente.command.edit.PacienteEditHandler;
import com.saludsystem.submodules.paciente.model.constant.PacienteConstant;
import com.saludsystem.submodules.paciente.model.dtos.command.create.PacienteCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.PacienteEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Pacientes")
@RestController
@RequestMapping("/api/Pacientes")
public class PacienteCommandController
{
	private final PacienteCreateHandler createHandler;
	private final PacienteEditHandler editHandler;
	private final PacienteDeleteHandler deleteHandler;
	private final FileStorageService fileStorageService;
	private final ObjectMapper objectMapper;

	public PacienteCommandController(
		PacienteCreateHandler createHandler,
		PacienteEditHandler editHandler,
		PacienteDeleteHandler deleteHandler,
		FileStorageService fileStorageService,
		ObjectMapper objectMapper)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
		this.fileStorageService = fileStorageService;
		this.objectMapper = objectMapper;
	}

	@PostMapping(value = "/Save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ApiResponse save(
		@RequestPart("paciente") String pacienteJson,
		@RequestPart(value = "foto", required = false) MultipartFile foto) throws IOException
	{
		PacienteCreateCommand createCommand = objectMapper.readValue(pacienteJson, PacienteCreateCommand.class);
		if (foto != null && !foto.isEmpty())
		{
			String url = fileStorageService.storeFileInSubfolder(foto, "pacientes");
			createCommand.setFotoPaciente(url);
		}
		createHandler.execute(createCommand);
		return new ApiResponse(true, PacienteConstant.CREATED);
	}

	@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
	@PutMapping(value = "/Update/{pacienteId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ApiResponse update(@PathVariable UUID pacienteId, @RequestBody PacienteEditCommand editCommand)
	{
		editHandler.execute(pacienteId, editCommand);
		return new ApiResponse(true, PacienteConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{pacienteId}")
	public ApiResponse destroy(@PathVariable UUID pacienteId)
	{
		deleteHandler.execute(pacienteId);
		return new ApiResponse(true, PacienteConstant.DELETED);
	}
}

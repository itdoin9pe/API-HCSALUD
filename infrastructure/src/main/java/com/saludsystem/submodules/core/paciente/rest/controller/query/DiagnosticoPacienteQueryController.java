package com.saludsystem.submodules.core.paciente.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.model.dtos.get.DiagnosticoDTO;
import com.saludsystem.submodules.paciente.query.getAll.DiagnosticoAllHandler;
import com.saludsystem.submodules.paciente.query.getById.DiagnosticoByIdHandler;
import com.saludsystem.submodules.paciente.query.getList.DiagnosticoListHandler;
import com.saludsystem.submodules.paciente.response.DiagnosticoListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesDiagnosticos")
@RestController
@RequestMapping("/api/Pacientes/Diagnosticos")
public class DiagnosticoPacienteQueryController
{
	private final DiagnosticoAllHandler allHandler;
	private final DiagnosticoByIdHandler byIdHandler;
	private final DiagnosticoListHandler listHandler;

	public DiagnosticoPacienteQueryController(
		DiagnosticoAllHandler allHandler,
		DiagnosticoByIdHandler byIdHandler,
		DiagnosticoListHandler listHandler)
	{
		this.allHandler = allHandler;
		this.byIdHandler = byIdHandler;
		this.listHandler = listHandler;
	}

	@GetMapping("/GetList")
	public List<DiagnosticoDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{id}")
	public DiagnosticoDTO getById(@PathVariable UUID id)
	{
		return byIdHandler.execute(id);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DiagnosticoListResponse.class))) })
	public ListResponse<DiagnosticoDTO> getAllPaginated(
		@RequestParam UUID hospitalId,
		@RequestParam(name = "Page") int page,
		@RequestParam(name = "Rows") int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}

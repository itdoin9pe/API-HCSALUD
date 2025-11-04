package com.saludsystem.submodules.core.paciente.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.model.dtos.get.EstudioMedicoDTO;
import com.saludsystem.submodules.paciente.query.getAll.EstudioMedicoAllHandler;
import com.saludsystem.submodules.paciente.query.getById.EstudioMedicoByIdHandler;
import com.saludsystem.submodules.paciente.query.getList.EstudioMedicoListHandler;
import com.saludsystem.submodules.paciente.response.EstudioMedicoListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesEstudiosMedicos")
@RestController
@RequestMapping("/api/PacientesEstudiosMedicos")
public class EstudioMedicoQueryController
{
	private final EstudioMedicoAllHandler allHandler;
	private final EstudioMedicoByIdHandler byIdHandler;
	private final EstudioMedicoListHandler listHandler;

	public EstudioMedicoQueryController(
		EstudioMedicoAllHandler allHandler,
		EstudioMedicoByIdHandler byIdHandler,
		EstudioMedicoListHandler listHandler)
	{
		this.allHandler = allHandler;
		this.byIdHandler = byIdHandler;
		this.listHandler = listHandler;
	}

	@GetMapping("/GetList")
	public List<EstudioMedicoDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{id}")
	public EstudioMedicoDTO getById(@PathVariable Long id)
	{
		return byIdHandler.execute(id);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EstudioMedicoListResponse.class))) })
	public ListResponse<EstudioMedicoDTO> getAllPage(
		@RequestParam(name = "hospitalId", required = true) UUID hospitalId,
		@RequestParam(name = "Page") int page,
		@RequestParam(name = "Rows") int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}

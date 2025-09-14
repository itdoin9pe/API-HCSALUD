package com.saludsystem.submodules.core.paciente.rest.controller.query.interconsulta;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.model.dtos.get.interconsulta.InterconsultaDTO;
import com.saludsystem.submodules.paciente.query.getAll.interconsulta.InterconsultaAllHandler;
import com.saludsystem.submodules.paciente.query.getById.interconsulta.InterconsultaByIdHandler;
import com.saludsystem.submodules.paciente.query.getList.interconsulta.InterconsultaListHandler;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesInterconsultas")
@RestController
@RequestMapping("/api/PacientesInterconsultas")
public class InterconsultaQueryController
{
	private final InterconsultaListHandler listHandler;
	private final InterconsultaByIdHandler byIdHandler;
	private final InterconsultaAllHandler allHandler;

	public InterconsultaQueryController(
		InterconsultaListHandler listHandler,
		InterconsultaByIdHandler byIdHandler,
		InterconsultaAllHandler allHandler)
	{
		this.listHandler = listHandler;
		this.byIdHandler = byIdHandler;
		this.allHandler = allHandler;
	}

	@GetMapping("/GetList")
	public List<InterconsultaDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{id}")
	public InterconsultaDTO getById(@PathVariable UUID id)
	{
		return byIdHandler.execute(id);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InterconsultaDTO.class))) })
	public ListResponse<InterconsultaDTO> getAll(
		@RequestParam UUID hospitalId,
		@RequestParam(name = "Page") int page,
		@RequestParam(name = "Rows") int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}

package com.saludsystem.submodules.core.configuracion.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.configuracion.model.dtos.ClinicaDTO;
import com.saludsystem.submodules.configuracion.query.getAll.ClinicaByIdHandler;
import com.saludsystem.submodules.configuracion.query.getById.ClinicaAllHandler;
import com.saludsystem.submodules.configuracion.query.getList.ClinicaListHandler;
import com.saludsystem.submodules.configuracion.response.ClinicaListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Hospitales")
@RestController
@RequestMapping("/api/Hospitales")
public class ClinicaQueryController
{
	private final ClinicaAllHandler allHandler;
	private final ClinicaListHandler listHandler;
	private final ClinicaByIdHandler byIdHandler;

	public ClinicaQueryController(
		ClinicaAllHandler allHandler,
		ClinicaListHandler listHandler,
		ClinicaByIdHandler byIdHandler)
	{
		this.allHandler = allHandler;
		this.listHandler = listHandler;
		this.byIdHandler = byIdHandler;
	}

	@GetMapping("/GetList")
	public List<ClinicaDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{hospitalId}")
	public ClinicaDTO getById(@PathVariable UUID hospitalId)
	{
		return byIdHandler.execute(hospitalId);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClinicaListResponse.class))) })

	public ListResponse<ClinicaDTO> getAllPage(
		@RequestParam(name = "hospitalId") UUID hospitalId,
		@RequestParam(name = "Page", defaultValue = "") int page,
		@RequestParam(name = "Rows", defaultValue = "") int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}
package com.saludsystem.submodules.core.operaciones.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.operaciones.model.dtos.UnidadDTO;
import com.saludsystem.submodules.operaciones.query.getAll.UnidadAllHandler;
import com.saludsystem.submodules.operaciones.query.getById.UnidadByIdHandler;
import com.saludsystem.submodules.operaciones.query.getList.UnidadListHandler;
import com.saludsystem.submodules.operaciones.response.UnidadListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Unidades")
@RestController
@RequestMapping("/api/Unidades")
public class UnidadQueryController
{
	private final UnidadAllHandler allHandler;
	private final UnidadListHandler listHandler;
	private final UnidadByIdHandler byIdHandler;

	public UnidadQueryController(
		UnidadAllHandler allHandler,
		UnidadListHandler listHandler,
		UnidadByIdHandler byIdHandler)
	{
		this.allHandler = allHandler;
		this.listHandler = listHandler;
		this.byIdHandler = byIdHandler;
	}

	@GetMapping("/GetList")
	public List<UnidadDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{unidadId}")
	public UnidadDTO getById(@PathVariable UUID unidadId)
	{
		return byIdHandler.execute(unidadId);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UnidadListResponse.class))) })
	public ListResponse<UnidadDTO> getAllPaginated(
		@RequestParam(name = "hospitalId") UUID hospitalId,
		@RequestParam(name = "Page", defaultValue = "") int page,
		@RequestParam(name = "Rows", defaultValue = "") int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}

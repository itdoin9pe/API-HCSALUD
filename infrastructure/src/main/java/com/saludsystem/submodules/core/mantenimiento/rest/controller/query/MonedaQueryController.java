package com.saludsystem.submodules.core.mantenimiento.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.mantenimiento.model.dtos.MonedaDTO;
import com.saludsystem.submodules.mantenimiento.query.getAll.MonedaAllHandler;
import com.saludsystem.submodules.mantenimiento.query.getById.MonedaByIdHandler;
import com.saludsystem.submodules.mantenimiento.query.getList.MonedaListHandler;
import com.saludsystem.submodules.mantenimiento.response.MonedaListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "TiposMonedas")
@RestController
@RequestMapping("/api/TiposMonedas")
public class MonedaQueryController
{
	private final MonedaAllHandler allHandler;
	private final MonedaListHandler listHandler;
	private final MonedaByIdHandler byIdHandler;

	public MonedaQueryController(
		MonedaAllHandler allHandler,
		MonedaListHandler listHandler,
		MonedaByIdHandler byIdHandler)
	{
		this.allHandler = allHandler;
		this.listHandler = listHandler;
		this.byIdHandler = byIdHandler;
	}

	@GetMapping("/GetList")
	public List<MonedaDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{monedaId}")
	public MonedaDTO getById(@PathVariable UUID monedaId)
	{
		return byIdHandler.execute(monedaId);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MonedaListResponse.class))) })
	public ListResponse<MonedaDTO> getAllPaginated(
		@RequestParam UUID hospitalId,
		@RequestParam(name = "Page") int page,
		@RequestParam(name = "Rows") int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}

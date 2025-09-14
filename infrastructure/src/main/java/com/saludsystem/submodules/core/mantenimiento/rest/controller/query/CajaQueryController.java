package com.saludsystem.submodules.core.mantenimiento.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.mantenimiento.model.dtos.CajaDTO;
import com.saludsystem.submodules.mantenimiento.query.getAll.CajaAllHandler;
import com.saludsystem.submodules.mantenimiento.query.getById.CajaByIdHandler;
import com.saludsystem.submodules.mantenimiento.query.getList.CajaListHandler;
import com.saludsystem.submodules.mantenimiento.response.CajaListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cajas")
@RestController
@RequestMapping("/api/Cajas")
public class CajaQueryController
{
	private final CajaListHandler listHandler;
	private final CajaAllHandler allHandler;
	private final CajaByIdHandler byIdHandler;

	public CajaQueryController(CajaListHandler listHandler, CajaAllHandler allHandler, CajaByIdHandler byIdHandler)
	{
		this.listHandler = listHandler;
		this.allHandler = allHandler;
		this.byIdHandler = byIdHandler;
	}

	@GetMapping("/GetList")
	public List<CajaDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{cajId}")
	public CajaDTO getById(@PathVariable UUID cajaId)
	{
		return byIdHandler.execute(cajaId);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CajaListResponse.class))) })
	public ListResponse<CajaDTO> getAllPaginated(
		@RequestParam UUID hospitalId,
		@RequestParam(name = "Page") int page,
		@RequestParam(name = "Rows") int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}

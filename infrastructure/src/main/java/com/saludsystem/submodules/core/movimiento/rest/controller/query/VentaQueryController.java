package com.saludsystem.submodules.core.movimiento.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.catalogo.response.AlergiaListResponse;
import com.saludsystem.submodules.movimiento.model.dtos.VentaDTO;
import com.saludsystem.submodules.movimiento.query.getAll.VentaAllHandler;
import com.saludsystem.submodules.movimiento.query.getById.VentaByIdHandler;
import com.saludsystem.submodules.movimiento.query.getList.VentaListHandler;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Ventas")
@RestController
@RequestMapping("/api/Ventas")
public class VentaQueryController
{
	private final VentaAllHandler allHandler;
	private final VentaByIdHandler byIdHandler;
	private final VentaListHandler listHandler;

	public VentaQueryController(VentaAllHandler allHandler, VentaByIdHandler byIdHandler, VentaListHandler listHandler)
	{
		this.allHandler = allHandler;
		this.byIdHandler = byIdHandler;
		this.listHandler = listHandler;
	}

	@GetMapping("/GetList")
	public List<VentaDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{ventaId}")
	public VentaDTO getById(@PathVariable UUID ventaId)
	{
		return byIdHandler.execute(ventaId);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlergiaListResponse.class))) })
	public ListResponse<VentaDTO> getAll(
		@RequestParam UUID hospitalId,
		@RequestParam(name = "Page") int page,
		@RequestParam(name = "Rows") int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}
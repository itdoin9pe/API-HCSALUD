package com.saludsystem.submodules.core.catalogo.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.catalogo.model.dto.TipoCitadoDTO;
import com.saludsystem.submodules.catalogo.query.getAll.TipoCitadoAllHandler;
import com.saludsystem.submodules.catalogo.query.getById.TipoCitadoByIdHandler;
import com.saludsystem.submodules.catalogo.query.getList.TipoCitadoListHandler;
import com.saludsystem.submodules.catalogo.response.TipoCitadoListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "TiposCitado")
@RestController
@RequestMapping("/api/TiposCitado")
public class TipoCitadoQueryController
{
	private final TipoCitadoByIdHandler byIdHandler;
	private final TipoCitadoAllHandler allHandler;
	private final TipoCitadoListHandler listHandler;

	public TipoCitadoQueryController(
		TipoCitadoByIdHandler byIdHandler,
		TipoCitadoAllHandler allHandler,
		TipoCitadoListHandler listHandler)
	{
		this.byIdHandler = byIdHandler;
		this.allHandler = allHandler;
		this.listHandler = listHandler;
	}

	@GetMapping("/GetList")
	public List<TipoCitadoDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{tipoCitadoId}")
	public TipoCitadoDTO getById(@PathVariable UUID tipoCitadoId)
	{
		return byIdHandler.execute(tipoCitadoId);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TipoCitadoListResponse.class))) })
	public ListResponse<TipoCitadoDTO> getAllPaginated(UUID hospitalId, int page, int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}

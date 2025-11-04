package com.saludsystem.submodules.core.operaciones.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.operaciones.model.dtos.TipoMaterialDTO;
import com.saludsystem.submodules.operaciones.query.getAll.TipoMaterialAllHandler;
import com.saludsystem.submodules.operaciones.query.getById.TipoMaterialByIdHandler;
import com.saludsystem.submodules.operaciones.query.getList.TipoMaterialListHandler;
import com.saludsystem.submodules.operaciones.response.TipoMaterialListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "TiposMateriales")
@RestController
@RequestMapping("/api/TiposMateriales")
public class TipoMaterialQueryController
{
	private final TipoMaterialAllHandler allHandler;
	private final TipoMaterialListHandler listHandler;
	private final TipoMaterialByIdHandler byIdHandler;

	public TipoMaterialQueryController(
		TipoMaterialAllHandler allHandler,
		TipoMaterialListHandler listHandler,
		TipoMaterialByIdHandler byIdHandler)
	{
		this.allHandler = allHandler;
		this.listHandler = listHandler;
		this.byIdHandler = byIdHandler;
	}

	@GetMapping("/GetList")
	public List<TipoMaterialDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{tipoMaterialId}")
	public TipoMaterialDTO getById(@PathVariable UUID tipoMaterialId)
	{
		return byIdHandler.execute(tipoMaterialId);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TipoMaterialListResponse.class))) })
	public ListResponse<TipoMaterialDTO> getAllPaginated(
		@RequestParam(name = "hospitalId") UUID hospitalId,
		@RequestParam(name = "Page", defaultValue = "") int page,
		@RequestParam(name = "Rows", defaultValue = "") int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}

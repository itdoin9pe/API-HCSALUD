package com.saludsystem.submodules.core.operaciones.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.operaciones.model.dtos.CategoriaMatDTO;
import com.saludsystem.submodules.operaciones.query.getAll.CategoriaMaterialAllHandler;
import com.saludsystem.submodules.operaciones.query.getById.CategoriaMaterialByIdHandler;
import com.saludsystem.submodules.operaciones.query.getList.CategoriaMaterialListHandler;
import com.saludsystem.submodules.operaciones.response.CategoriaMatListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "CategoriasMateriales")
@RestController
@RequestMapping("/api/CategoriasMateriales")
public class CategoriaMatQueryController
{
	private final CategoriaMaterialListHandler listHandler;
	private final CategoriaMaterialAllHandler allHandler;
	private final CategoriaMaterialByIdHandler byIdHandler;

	public CategoriaMatQueryController(
		CategoriaMaterialListHandler listHandler,
		CategoriaMaterialAllHandler allHandler,
		CategoriaMaterialByIdHandler byIdHandler)
	{
		this.listHandler = listHandler;
		this.allHandler = allHandler;
		this.byIdHandler = byIdHandler;
	}

	@GetMapping("/GetList")
	public List<CategoriaMatDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{categoriaMaterialId}")
	public CategoriaMatDTO getById(@PathVariable UUID categoriaMaterialId)
	{
		return byIdHandler.execute(categoriaMaterialId);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaMatListResponse.class))) })
	public ListResponse<CategoriaMatDTO> getAllPaginated(
		@RequestParam UUID hospitalId,
		@RequestParam(name = "Page") int page,
		@RequestParam(name = "Rows") int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}

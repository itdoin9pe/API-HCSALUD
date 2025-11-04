package com.saludsystem.submodules.core.catalogo.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.catalogo.model.dto.AlergiaDTO;
import com.saludsystem.submodules.catalogo.query.getAll.AlergiaAllHandler;
import com.saludsystem.submodules.catalogo.query.getById.AlergiaByIdHandler;
import com.saludsystem.submodules.catalogo.query.getList.AlergiaListHandler;
import com.saludsystem.submodules.catalogo.response.AlergiaListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Alergias")
@RestController
@RequestMapping("/api/Alergias")
public class AlergiaQueryController
{
	private final AlergiaAllHandler allHandler;
	private final AlergiaByIdHandler byIdHandler;
	private final AlergiaListHandler listHandler;

	public AlergiaQueryController(
		AlergiaAllHandler allHandler,
		AlergiaByIdHandler byIdHandler,
		AlergiaListHandler listHandler)
	{
		this.allHandler = allHandler;
		this.byIdHandler = byIdHandler;
		this.listHandler = listHandler;
	}

	@GetMapping("/GetList")
	public List<AlergiaDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{alergiaId}")
	public AlergiaDTO getById(@PathVariable UUID alergiaId)
	{
		return byIdHandler.execute(alergiaId);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlergiaListResponse.class))) })
	public ListResponse<AlergiaDTO> getAll(
		@RequestParam UUID hospitalId,
		@RequestParam(name = "Page") int page,
		@RequestParam(name = "Rows") int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}

}
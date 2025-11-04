package com.saludsystem.submodules.core.configuracion.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.configuracion.model.dtos.SedeDTO;
import com.saludsystem.submodules.configuracion.query.getAll.SedeByIdHandler;
import com.saludsystem.submodules.configuracion.query.getById.SedeAllHandler;
import com.saludsystem.submodules.configuracion.query.getList.SedeListHandler;
import com.saludsystem.submodules.configuracion.response.SedeListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Sedes")
@RestController
@RequestMapping("/api/Sedes")
public class SedeQueryController
{
	private final SedeAllHandler allHandler;
	private final SedeByIdHandler byIdHandler;
	private final SedeListHandler listHandler;

	public SedeQueryController(SedeAllHandler allHandler, SedeByIdHandler byIdHandler, SedeListHandler listHandler)
	{
		this.allHandler = allHandler;
		this.byIdHandler = byIdHandler;
		this.listHandler = listHandler;
	}

	@GetMapping("/GetList")
	public List<SedeDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{sedeId}")
	public SedeDTO getById(@PathVariable UUID sedeId)
	{
		return byIdHandler.execute(sedeId);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SedeListResponse.class))) })
	public ListResponse<SedeDTO> getAllPaginated(
		@RequestParam UUID hospitalId,
		@RequestParam(name = "Page") int page,
		@RequestParam(name = "Rows") int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}

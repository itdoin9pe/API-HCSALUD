package com.saludsystem.submodules.core.catalogo.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.catalogo.model.dto.EspecialidadDTO;
import com.saludsystem.submodules.catalogo.query.getAll.EspecialidadAllHandler;
import com.saludsystem.submodules.catalogo.query.getById.EspecialidadByIdHandler;
import com.saludsystem.submodules.catalogo.query.getList.EspecialidadListHandler;
import com.saludsystem.submodules.catalogo.response.EspecialidadListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Especialidades")
@RestController
@RequestMapping("/api/Especialidades")
public class EspecialidadQueryController
{
	private final EspecialidadByIdHandler byIdHandler;
	private final EspecialidadAllHandler allHandler;
	private final EspecialidadListHandler listHandler;

	public EspecialidadQueryController(
		EspecialidadByIdHandler byIdHandler,
		EspecialidadAllHandler allHandler,
		EspecialidadListHandler listHandler)
	{
		this.byIdHandler = byIdHandler;
		this.allHandler = allHandler;
		this.listHandler = listHandler;
	}

	@GetMapping("/GetList")
	public List<EspecialidadDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetLis/{especialidadId}")
	public EspecialidadDTO getById(@PathVariable UUID especialidadId)
	{
		return byIdHandler.execute(especialidadId);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EspecialidadListResponse.class))) })
	public ListResponse<EspecialidadDTO> getAllPaginated(
		@RequestParam UUID hospitalId,
		@RequestParam(name = "Page") Integer page,
		@RequestParam(name = "Rows") Integer rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}
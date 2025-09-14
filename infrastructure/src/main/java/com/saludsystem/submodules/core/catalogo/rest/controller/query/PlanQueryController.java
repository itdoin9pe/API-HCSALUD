package com.saludsystem.submodules.core.catalogo.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.catalogo.model.dto.PlanDTO;
import com.saludsystem.submodules.catalogo.query.getAll.PlanAllHandler;
import com.saludsystem.submodules.catalogo.query.getById.PlanByIdHandler;
import com.saludsystem.submodules.catalogo.query.getList.PlanListHandler;
import com.saludsystem.submodules.catalogo.response.PlanListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Planes")
@RestController
@RequestMapping("/api/Planes")
public class PlanQueryController
{
	private final PlanByIdHandler byIdHandler;
	private final PlanAllHandler allHandler;
	private final PlanListHandler listHandler;

	public PlanQueryController(PlanByIdHandler byIdHandler, PlanAllHandler allHandler, PlanListHandler listHandler)
	{
		this.byIdHandler = byIdHandler;
		this.allHandler = allHandler;
		this.listHandler = listHandler;
	}

	@GetMapping("/GetList")
	public List<PlanDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{planId}")
	public PlanDTO getById(@PathVariable UUID planId)
	{
		return byIdHandler.execute(planId);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PlanListResponse.class))) })
	public ListResponse<PlanDTO> getAllPaginated(
		@RequestParam UUID hospitalId,
		@RequestParam(name = "Page") int page,
		@RequestParam(name = "Rows") int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}

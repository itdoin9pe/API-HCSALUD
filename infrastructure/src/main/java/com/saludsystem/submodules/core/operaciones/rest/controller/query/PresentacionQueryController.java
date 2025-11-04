package com.saludsystem.submodules.core.operaciones.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.operaciones.model.dtos.PresentacionDTO;
import com.saludsystem.submodules.operaciones.query.getAll.PresentacionAllHandler;
import com.saludsystem.submodules.operaciones.query.getById.PresentacionByIdHandler;
import com.saludsystem.submodules.operaciones.query.getList.PresentacionListHandler;
import com.saludsystem.submodules.operaciones.response.PresentacionListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Presentaciones")
@RestController
@RequestMapping("/api/Presentaciones")
public class PresentacionQueryController
{
	private final PresentacionAllHandler allHandler;
	private final PresentacionByIdHandler byIdHandler;
	private final PresentacionListHandler listHandler;

	public PresentacionQueryController(
		PresentacionAllHandler allHandler,
		PresentacionByIdHandler byIdHandler,
		PresentacionListHandler listHandler)
	{
		this.allHandler = allHandler;
		this.byIdHandler = byIdHandler;
		this.listHandler = listHandler;
	}

	@GetMapping("/GetList")
	public List<PresentacionDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{presentacionId}")
	public PresentacionDTO getById(@PathVariable UUID presentacionId)
	{
		return byIdHandler.execute(presentacionId);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PresentacionListResponse.class))) })
	public ListResponse<PresentacionDTO> getAllPaginated(
		@RequestParam UUID hospitalId,
		@RequestParam(name = "Page") int page,
		@RequestParam(name = "Rows") int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}

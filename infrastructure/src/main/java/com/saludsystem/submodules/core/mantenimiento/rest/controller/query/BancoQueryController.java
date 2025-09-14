package com.saludsystem.submodules.core.mantenimiento.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.mantenimiento.model.dtos.BancoDTO;
import com.saludsystem.submodules.mantenimiento.query.getAll.BancoAllHandler;
import com.saludsystem.submodules.mantenimiento.query.getById.BancoByIdHandler;
import com.saludsystem.submodules.mantenimiento.query.getList.BancoListHandler;
import com.saludsystem.submodules.mantenimiento.response.BancoListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Bancos")
@RestController
@RequestMapping("/api/Bancos")
public class BancoQueryController
{
	private final BancoListHandler listHandler;
	private final BancoByIdHandler byIdHandler;
	private final BancoAllHandler allHandler;

	public BancoQueryController(BancoListHandler listHandler, BancoByIdHandler byIdHandler, BancoAllHandler allHandler)
	{
		this.listHandler = listHandler;
		this.byIdHandler = byIdHandler;
		this.allHandler = allHandler;
	}

	@GetMapping("/GetList")
	public List<BancoDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{bancoId}")
	public BancoDTO getById(@PathVariable UUID bancoId)
	{
		return byIdHandler.execute(bancoId);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BancoListResponse.class))) })
	public ListResponse<BancoDTO> getAllPaginated(UUID hospitalId, int page, int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}

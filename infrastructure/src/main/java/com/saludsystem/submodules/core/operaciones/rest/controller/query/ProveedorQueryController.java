package com.saludsystem.submodules.core.operaciones.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.operaciones.model.dtos.ProveedorDTO;
import com.saludsystem.submodules.operaciones.query.getAll.ProveedorAllHandler;
import com.saludsystem.submodules.operaciones.query.getById.ProveedorByIdHandler;
import com.saludsystem.submodules.operaciones.query.getList.ProveedorListHandler;
import com.saludsystem.submodules.operaciones.response.ProveedorListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Proveedor")
@RestController
@RequestMapping("/api/Proveedor")
public class ProveedorQueryController
{
	private final ProveedorAllHandler allHandler;
	private final ProveedorByIdHandler byIdHandler;
	private final ProveedorListHandler listHandler;

	public ProveedorQueryController(
		ProveedorAllHandler allHandler,
		ProveedorByIdHandler byIdHandler,
		ProveedorListHandler listHandler)
	{
		this.allHandler = allHandler;
		this.byIdHandler = byIdHandler;
		this.listHandler = listHandler;
	}

	@GetMapping("/GetList")
	public List<ProveedorDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{proveedorId}")
	public ProveedorDTO getById(@PathVariable UUID proveedorId)
	{
		return byIdHandler.execute(proveedorId);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProveedorListResponse.class))) })
	public ListResponse<ProveedorDTO> getAllPaginated(
		@RequestParam(name = "hospitalId") UUID hospitalId,
		@RequestParam(name = "Page", defaultValue = "") int page,
		@RequestParam(name = "Rows", defaultValue = "") int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}

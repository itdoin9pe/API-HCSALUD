package com.saludsystem.submodules.core.movimiento.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.cita.response.CitaListResponse;
import com.saludsystem.submodules.movimiento.model.dtos.InventarioDTO;
import com.saludsystem.submodules.movimiento.query.getAll.InventarioAllHandler;
import com.saludsystem.submodules.movimiento.query.getById.InventarioByIdHandler;
import com.saludsystem.submodules.movimiento.query.getList.InventarioListHandler;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Inventarios")
@RestController
@RequestMapping("/api/Inventarios")
public class InventarioQueryController {

	private final InventarioListHandler listHandler;
	private final InventarioByIdHandler byIdHandler;
	private final InventarioAllHandler allHandler;
	
	/**
	 * @param listHandler
	 * @param byIdHandler
	 * @param allHandler
	 */
	public InventarioQueryController(InventarioListHandler listHandler, InventarioByIdHandler byIdHandler,
			InventarioAllHandler allHandler) {
		this.listHandler = listHandler;
		this.byIdHandler = byIdHandler;
		this.allHandler = allHandler;
	}

	@GetMapping("/GetList")
	public List<InventarioDTO> getList() {
		return listHandler.execute();
	}

	@GetMapping("/GetById/{inventarioId}")
	public InventarioDTO getById(@PathVariable UUID inventarioId) {
		return byIdHandler.execute(inventarioId);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value = {
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", 
					description = "Operación exitosa", 
					content = @Content(mediaType = "application/json", 
					schema = @Schema(implementation = CitaListResponse.class))) })
	public ListResponse<InventarioDTO> getAllPaginated(
			@RequestParam UUID hospitalId, 
			@RequestParam(name = "Page") int page,
			@RequestParam(name = "Rows") int rows) {
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}

package com.saludsystem.submodules.core.configuracion.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.configuracion.model.dtos.RolDTO;
import com.saludsystem.submodules.configuracion.query.getAll.RolAllHandler;
import com.saludsystem.submodules.configuracion.query.getById.RolByIdHandler;
import com.saludsystem.submodules.configuracion.query.getList.RolListHandler;
import com.saludsystem.submodules.configuracion.response.RolListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Roles")
@RestController
@RequestMapping("/api/Roles")
public class RolQueryController {

	private final RolAllHandler allHandler;
	private final RolListHandler listHandler;
	private final RolByIdHandler byIdHandler;

	public RolQueryController(RolAllHandler allHandler, RolListHandler listHandler, RolByIdHandler byIdHandler) {
		this.allHandler = allHandler;
		this.listHandler = listHandler;
		this.byIdHandler = byIdHandler;
	}

	@GetMapping("/GetList")
	public List<RolDTO> getList() {
		return listHandler.execute();
	}

	@GetMapping("/GetRoleById/{roleId}")
	public RolDTO getById(@PathVariable UUID roleId) {
		return byIdHandler.execute(roleId);
	}

	@GetMapping("/GetAllRol")
	@ApiResponses(value = {
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", 
					description = "Operación exitosa", 
					content = @Content(mediaType = "application/json", 
					schema = @Schema(implementation = RolListResponse.class))) })
	public ListResponse<RolDTO> getAllPage(
		@RequestParam(name = "hospitalId", required = true) UUID hospitalId,
		@RequestParam(name = "Page") int page,
		@RequestParam(name = "Rows") int rows) {
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}

}

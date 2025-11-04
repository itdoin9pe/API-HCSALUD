package com.saludsystem.submodules.core.cita.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.cita.model.dtos.CitaDTO;
import com.saludsystem.submodules.cita.query.CitaAllHandler;
import com.saludsystem.submodules.cita.query.CitaByIdHandler;
import com.saludsystem.submodules.cita.query.CitaListHandler;
import com.saludsystem.submodules.cita.response.CitaListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "CitasMedicas")
@RestController
@RequestMapping("/api/CitasMedicas")
public class CitaQueryController
{
	private final CitaAllHandler allHandler;
	private final CitaByIdHandler byIdHandler;
	private final CitaListHandler listHandler;

	public CitaQueryController(CitaAllHandler allHandler, CitaByIdHandler byIdHandler, CitaListHandler listHandler)
	{
		this.allHandler = allHandler;
		this.byIdHandler = byIdHandler;
		this.listHandler = listHandler;
	}

	@GetMapping("/GetList")
	public List<CitaDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{citaId}")
	public CitaDTO getById(@PathVariable UUID citaId)
	{
		return byIdHandler.execute(citaId);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CitaListResponse.class))) })
	public ListResponse<CitaDTO> getAllPaginated(
		@RequestParam UUID hospitalId,
		@RequestParam(name = "Page") int page,
		@RequestParam(name = "Rows") int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}

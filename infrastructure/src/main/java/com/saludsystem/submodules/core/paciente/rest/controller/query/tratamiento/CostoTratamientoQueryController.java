package com.saludsystem.submodules.core.paciente.rest.controller.query.tratamiento;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.model.dtos.get.tratamiento.CostoTratamientoDTO;
import com.saludsystem.submodules.paciente.query.getAll.tratamiento.CostoTratamientoAllHandler;
import com.saludsystem.submodules.paciente.query.getById.tratamiento.CostoTratamientoByIdHandler;
import com.saludsystem.submodules.paciente.query.getList.tratamiento.CostoTratamientoListHandler;
import com.saludsystem.submodules.paciente.response.tratamiento.CostoTratamientoListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesCostosTratamientos")
@RestController
@RequestMapping("/api/Pacientes/CostosTratamientos")
public class CostoTratamientoQueryController
{
	private final CostoTratamientoListHandler listHandler;
	private final CostoTratamientoByIdHandler byIdHandler;
	private final CostoTratamientoAllHandler allHandler;

	public CostoTratamientoQueryController(
		CostoTratamientoListHandler listHandler,
		CostoTratamientoByIdHandler byIdHandler,
		CostoTratamientoAllHandler allHandler)
	{
		this.listHandler = listHandler;
		this.byIdHandler = byIdHandler;
		this.allHandler = allHandler;
	}

	@GetMapping("/GetList")
	public List<CostoTratamientoDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{id}")
	public CostoTratamientoDTO getById(@PathVariable UUID id)
	{
		return byIdHandler.execute(id);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CostoTratamientoListResponse.class))) })
	public ListResponse<CostoTratamientoDTO> getAllPaginated(
		@RequestParam UUID hospitalId,
		@RequestParam(name = "Page") int page,
		@RequestParam(name = "Rows") int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}

package com.saludsystem.submodules.core.paciente.rest.controller.query.evolucion;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.AltaMedicaDTO;
import com.saludsystem.submodules.paciente.query.getAll.evolucion.AltaMedicaAllHandler;
import com.saludsystem.submodules.paciente.query.getById.evolucion.AltaMedicaByIdHandler;
import com.saludsystem.submodules.paciente.query.getList.evolucion.AltaMedicaListHandler;
import com.saludsystem.submodules.paciente.response.evolucion.AltaMedicaListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesEvolucionesAltasMedicas")
@RestController
@RequestMapping("/api/Pacientes/Evoluciones/AltasMedicas")
public class AltaMedicaQueryController
{
	private final AltaMedicaListHandler listHandler;
	private final AltaMedicaByIdHandler byIdHandler;
	private final AltaMedicaAllHandler allHandler;

	public AltaMedicaQueryController(
		AltaMedicaListHandler listHandler,
		AltaMedicaByIdHandler byIdHandler,
		AltaMedicaAllHandler allHandler)
	{
		this.listHandler = listHandler;
		this.byIdHandler = byIdHandler;
		this.allHandler = allHandler;
	}

	@GetMapping("/GetList")
	public List<AltaMedicaDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{id}")
	public AltaMedicaDTO getById(@PathVariable Long id)
	{
		return byIdHandler.execute(id);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AltaMedicaListResponse.class))) })
	public ListResponse<AltaMedicaDTO> getAllPage(
		@RequestParam(name = "hospitalId", required = true) UUID hospitalId,
		@RequestParam(name = "Page") int page,
		@RequestParam(name = "Rows") int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}

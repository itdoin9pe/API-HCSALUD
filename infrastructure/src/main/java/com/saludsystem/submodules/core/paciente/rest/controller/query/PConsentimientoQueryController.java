package com.saludsystem.submodules.core.paciente.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.model.dtos.get.PConsentimientoDTO;
import com.saludsystem.submodules.paciente.query.getAll.PConsentimientoAllHandler;
import com.saludsystem.submodules.paciente.query.getById.PConsentimientoByIdHandler;
import com.saludsystem.submodules.paciente.query.getList.PConsentimientoListHandler;
import com.saludsystem.submodules.paciente.response.PConsentimientoListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesConsentimientos")
@RestController
@RequestMapping("/api/Pacientes/Consentimientos")
public class PConsentimientoQueryController
{
	private final PConsentimientoAllHandler allHandler;
	private final PConsentimientoByIdHandler byIdHandler;
	private final PConsentimientoListHandler listHandler;

	public PConsentimientoQueryController(
		PConsentimientoAllHandler allHandler,
		PConsentimientoByIdHandler byIdHandler,
		PConsentimientoListHandler listHandler)
	{
		this.allHandler = allHandler;
		this.byIdHandler = byIdHandler;
		this.listHandler = listHandler;
	}

	@GetMapping("/GetList")
	public List<PConsentimientoDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetDoctor/{doctorId}")
	public PConsentimientoDTO getById(@PathVariable UUID doctorId)
	{
		return byIdHandler.execute(doctorId);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PConsentimientoListResponse.class))) })
	public ListResponse<PConsentimientoDTO> getAllPaginated(
		@RequestParam(name = "hospitalId", required = true) UUID hospitalId,
		@RequestParam(name = "Page") int page,
		@RequestParam(name = "Rows") int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}

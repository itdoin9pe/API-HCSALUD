package com.saludsystem.submodules.core.paciente.rest.controller.query.estadocuenta;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.EstadoCuentaDTO;
import com.saludsystem.submodules.paciente.query.getAll.estadocuenta.EstadoCuentaAllHandler;
import com.saludsystem.submodules.paciente.query.getById.estadocuenta.EstadoCuentaByIdHandler;
import com.saludsystem.submodules.paciente.query.getList.estadocuenta.EstadoCuentaListHandler;
import com.saludsystem.submodules.paciente.response.estadocuenta.EstadoCuentaListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesEstadosCuentas")
@RestController
@RequestMapping("/api/Pacientes/EstadosCuentas")
public class EstadoCuentaQueryController
{
	private final EstadoCuentaListHandler listHandler;
	private final EstadoCuentaByIdHandler byIdHandler;
	private final EstadoCuentaAllHandler allHandler;

	public EstadoCuentaQueryController(
		EstadoCuentaListHandler listHandler,
		EstadoCuentaByIdHandler byIdHandler,
		EstadoCuentaAllHandler allHandler)
	{
		this.listHandler = listHandler;
		this.byIdHandler = byIdHandler;
		this.allHandler = allHandler;
	}

	@GetMapping("/GetList")
	public List<EstadoCuentaDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{id}")
	public EstadoCuentaDTO getById(@PathVariable UUID id)
	{
		return byIdHandler.execute(id);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EstadoCuentaListResponse.class))) })
	public ListResponse<EstadoCuentaDTO> getAllPaginated(
		@RequestParam UUID hospitalId,
		@RequestParam(name = "Page") int page,
		@RequestParam(name = "Rows") int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}

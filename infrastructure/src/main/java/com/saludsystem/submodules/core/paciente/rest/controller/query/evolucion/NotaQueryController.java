package com.saludsystem.submodules.core.paciente.rest.controller.query.evolucion;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.NotaDTO;
import com.saludsystem.submodules.paciente.query.getAll.evolucion.NotaAllHandler;
import com.saludsystem.submodules.paciente.query.getById.evolucion.NotaByIdHandler;
import com.saludsystem.submodules.paciente.query.getList.evolucion.NotaListHandler;
import com.saludsystem.submodules.paciente.response.evolucion.NotaListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesEvolucionesNotas")
@RestController
@RequestMapping("/api/Pacientes/Evololuciones/Notas")
public class NotaQueryController
{
	private final NotaListHandler listHandler;
	private final NotaByIdHandler byIdHandler;
	private final NotaAllHandler allHandler;

	public NotaQueryController(NotaListHandler listHandler, NotaByIdHandler byIdHandler, NotaAllHandler allHandler)
	{
		this.listHandler = listHandler;
		this.byIdHandler = byIdHandler;
		this.allHandler = allHandler;
	}

	@GetMapping("/GetList")
	public List<NotaDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{id}")
	public NotaDTO getById(@PathVariable Long id)
	{
		return byIdHandler.execute(id);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = NotaListResponse.class))) })
	public ListResponse<NotaDTO> getAllPage(
		@RequestParam(name = "hospitalId", required = true) UUID hospitalId,
		@RequestParam(name = "Page") int page,
		@RequestParam(name = "Rows") int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}

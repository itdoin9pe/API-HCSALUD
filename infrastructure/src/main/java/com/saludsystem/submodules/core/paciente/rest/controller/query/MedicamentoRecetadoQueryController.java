package com.saludsystem.submodules.core.paciente.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.model.dtos.get.MedicamentoRecetadoDTO;
import com.saludsystem.submodules.paciente.query.getAll.MedicamentoRecetadoAllHandler;
import com.saludsystem.submodules.paciente.query.getById.MedicamentoRecetadoByIdHandler;
import com.saludsystem.submodules.paciente.query.getList.MedicamentoRecetadoListHandler;
import com.saludsystem.submodules.paciente.response.MedicamentoRecetadoListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PacientesMedicamentosRecetados")
@RestController
@RequestMapping("/api/Pacientes/MedicamentosRecetados")
public class MedicamentoRecetadoQueryController
{
	private final MedicamentoRecetadoListHandler listHandler;
	private final MedicamentoRecetadoByIdHandler byIdHandler;
	private final MedicamentoRecetadoAllHandler allHandler;

	public MedicamentoRecetadoQueryController(
		MedicamentoRecetadoListHandler listHandler,
		MedicamentoRecetadoByIdHandler byIdHandler,
		MedicamentoRecetadoAllHandler allHandler)
	{
		this.listHandler = listHandler;
		this.byIdHandler = byIdHandler;
		this.allHandler = allHandler;
	}

	@GetMapping("/GetList")
	public List<MedicamentoRecetadoDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{id}")
	public MedicamentoRecetadoDTO getById(@PathVariable UUID id)
	{
		return byIdHandler.execute(id);
	}

	@GetMapping("/GetAll")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MedicamentoRecetadoListResponse.class))) })
	public ListResponse<MedicamentoRecetadoDTO> getAllPaginated(
		@RequestParam(name = "hospitalId", required = true) UUID hospitalId,
		@RequestParam(name = "Page") int page,
		@RequestParam(name = "Rows") int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}
}

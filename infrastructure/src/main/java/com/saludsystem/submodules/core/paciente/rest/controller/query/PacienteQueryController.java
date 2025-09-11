package com.saludsystem.submodules.core.paciente.rest.controller.query;

import java.net.MalformedURLException; // Para controlar la excepción en UrlResource
import java.nio.file.Path;
import java.nio.file.Paths; // Para manejar rutas del sistema de archivos
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.Resource; // Interface común para recursos en Spring
import org.springframework.core.io.UrlResource; // Implementación que carga desde una URL o file path
import org.springframework.http.MediaType; // Para definir tipo de contenido (ej. PNG, JPEG, etc.)
import org.springframework.http.ResponseEntity; // Para armar la respuesta HTTP
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.paciente.model.dtos.get.PacienteDTO;
import com.saludsystem.submodules.paciente.query.getAll.PacienteAllHandler;
import com.saludsystem.submodules.paciente.query.getById.PacienteByIdHandler;
import com.saludsystem.submodules.paciente.query.getList.PacienteListHandler;
import com.saludsystem.submodules.paciente.response.PacienteListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Pacientes")
@RestController
@RequestMapping("/api/Pacientes")
public class PacienteQueryController
{
	private final PacienteListHandler listHandler;
	private final PacienteByIdHandler byIdHandler;
	private final PacienteAllHandler allHandler;

	public PacienteQueryController(
		PacienteListHandler listHandler,
		PacienteByIdHandler byIdHandler,
		PacienteAllHandler allHandler)
	{
		this.listHandler = listHandler;
		this.byIdHandler = byIdHandler;
		this.allHandler = allHandler;
	}

	@GetMapping("/GetList")
	public List<PacienteDTO> getList()
	{
		return listHandler.execute();
	}

	@GetMapping("/GetById/{pacienteId}")
	public PacienteDTO getById(@PathVariable UUID pacienteId)
	{
		return byIdHandler.execute(pacienteId);
	}

	@GetMapping("/GetAllPaciente")
	@ApiResponses(value =
	{ @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PacienteListResponse.class))) })
	public ListResponse<PacienteDTO> getAll(
		@RequestParam(name = "hospitalId", required = true) UUID hospitalId,
		@RequestParam(name = "Page") int page,
		@RequestParam(name = "Rows") int rows)
	{
		return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	}

	@GetMapping("/GetImage")
	public ResponseEntity<Resource> getImage(@RequestParam String imageName) throws MalformedURLException
	{
		// Remover el prefijo "/uploads/" si viene incluido
		String cleanImageName = imageName.replaceFirst("^/uploads/", "");
		Path path = Paths.get("uploads").resolve(cleanImageName).normalize();
		Resource resource = new UrlResource(path.toUri());

		if (!resource.exists())
		{
			return ResponseEntity.notFound().build();
		}

		// Determinar el tipo MIME dinámicamente
		String contentType = determineContentType(cleanImageName);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).body(resource);
	}

	private String determineContentType(String filename)
	{
		if (filename.endsWith(".png"))
		{
			return "image/png";
		}
		if (filename.endsWith(".jpg") || filename.endsWith(".jpeg"))
		{
			return "image/jpeg";
		}
		if (filename.endsWith(".gif"))
		{
			return "image/gif";
		}
		return "application/octet-stream";
	}
}
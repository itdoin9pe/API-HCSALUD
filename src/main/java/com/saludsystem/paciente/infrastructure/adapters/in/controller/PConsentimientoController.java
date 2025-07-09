package com.saludsystem.paciente.infrastructure.adapters.in.controller;

import com.saludsystem.paciente.application.dto.get.PConsentimientoDTO;
import com.saludsystem.paciente.application.dto.post.CrearPConsentimientoDTO;
import com.saludsystem.paciente.application.dto.put.ActualizarPConsentimientoDTO;
import com.saludsystem.paciente.infrastructure.adapters.in.response.PConsentimientoListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Tag(name = "PacientesConsentimientos")
@RestController
@RequestMapping("/api/Pacientes/Consentimientos")
public class PConsentimientoController extends GenericController<PConsentimientoDTO, CrearPConsentimientoDTO,
        ActualizarPConsentimientoDTO, UUID> {

    protected PConsentimientoController(
            GenericService<PConsentimientoDTO, CrearPConsentimientoDTO,
                    ActualizarPConsentimientoDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @PostMapping(value = "/Save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success",
            content = @Content(schema = @Schema(implementation = PConsentimientoListResponse.class)))
    public ApiResponse create(@RequestBody CrearPConsentimientoDTO crearPConsentimientoDTO) {
        return super.create(crearPConsentimientoDTO);
    }

    @Override
    @PutMapping(value = "/Update/{pacienteConsentimientoId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success",
            content = @Content(schema = @Schema(implementation = PConsentimientoListResponse.class)))
    public ApiResponse update(@PathVariable("pacienteConsentimientoId") UUID uuid, ActualizarPConsentimientoDTO dto) {
        return super.update(uuid, dto);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PConsentimientoListResponse.class)))
    })
    public ListResponse<PConsentimientoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @GetMapping("/GetImage")
    public ResponseEntity<org.springframework.core.io.Resource> getImage(@RequestParam String imageName) throws IOException {
        Path imagePath = Paths.get("uploads/firmas").resolve(imageName).normalize();
        if (!Files.exists(imagePath)) {
            return ResponseEntity.notFound().build();
        }
        Resource resource = new UrlResource(imagePath.toUri());
        String contentType = Files.probeContentType(imagePath);
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).body(resource);
    }
}
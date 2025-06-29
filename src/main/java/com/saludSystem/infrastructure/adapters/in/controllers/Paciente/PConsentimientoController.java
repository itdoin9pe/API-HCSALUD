package com.saludSystem.infrastructure.adapters.in.controllers.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.PConsentimientoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearPConsentimientoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarPConsentimiento;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.PConsentimientoResponse;
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
public class PConsentimientoController extends GenericController<PConsentimientoDTO, UUID,
        CrearPConsentimientoDTO, ActualizarPConsentimiento> {

    protected PConsentimientoController(GenericService<PConsentimientoDTO, UUID, CrearPConsentimientoDTO, ActualizarPConsentimiento> genericService) {
        super(genericService);
    }

    @Override
    @PostMapping(value = "/Save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success",
            content = @Content(schema = @Schema(implementation = PConsentimientoResponse.class)))
    public ApiResponse create(@RequestBody CrearPConsentimientoDTO crearPConsentimientoDTO) {
        return super.create(crearPConsentimientoDTO);
    }

    @Override
    @PutMapping(value = "/Update/{Id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success",
            content = @Content(schema = @Schema(implementation = PConsentimientoResponse.class)))
    public ApiResponse update(@PathVariable UUID pacienteConsentimientoId, @RequestBody ActualizarPConsentimiento actualizarPConsentimiento) {
        return super.update(pacienteConsentimientoId, actualizarPConsentimiento);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PConsentimientoResponse.class)))
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
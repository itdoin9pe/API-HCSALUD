package com.saludSystem.infrastructure.adapters.in.controllers.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.PConsentimientoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearPConsentimientoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarPConsentimiento;
import com.saludSystem.application.services.Paciente.PConsentimientoService;
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
@RequestMapping("/api/PacientesConocimientos")
public class PConsentimientoController {

    private final PConsentimientoService pConsentimientoService;

    public PConsentimientoController(PConsentimientoService pConsentimientoService) {
        this.pConsentimientoService = pConsentimientoService;
    }

    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success",
            content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    @PostMapping(value = "/SavePacienteConsentimiento", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse> save(@RequestBody CrearPConsentimientoDTO crearPConsentimientoDTO) {
        return ResponseEntity.ok(pConsentimientoService.savePConsentiemiento(crearPConsentimientoDTO));
    }

    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success",
            content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    @PutMapping(value = "/UpdatePacienteConsentimiento/{pacienteConsentimientoId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse update(@PathVariable UUID pacienteConsentimientoId, @RequestBody ActualizarPConsentimiento actualizarPConsentimiento) {
        return pConsentimientoService.updatePConsentimiento(pacienteConsentimientoId, actualizarPConsentimiento);
    }

    @DeleteMapping("/DeletePacienteConsentimiento/{pacienteConsentimientoId}")
    public ApiResponse delete(@PathVariable UUID pacienteConsentimientoId) {
        return pConsentimientoService.deletePConsentimiento(pacienteConsentimientoId);
    }

    @GetMapping("/GetPacienteConsentimiento/{pacienteConsentimientoId}")
    public PConsentimientoDTO getById(@PathVariable UUID pacienteConsentimientoId) {
        return pConsentimientoService.getPConsentimientoById(pacienteConsentimientoId);
    }

    @GetMapping("/GetAllPacienteConsentimiento")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PConsentimientoResponse.class)))
    })
    public ListResponse<PConsentimientoDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return pConsentimientoService.getAllPConsentimiento(hospitalId, page, rows);
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
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(resource);
    }

}
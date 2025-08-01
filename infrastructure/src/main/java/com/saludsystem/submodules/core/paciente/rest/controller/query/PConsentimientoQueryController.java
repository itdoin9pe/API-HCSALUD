package com.saludsystem.submodules.core.paciente.rest.controller.query;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "PacientesConsentimientos")
@RestController
@RequestMapping("/api/Pacientes/Consentimientos")
public class PConsentimientoQueryController {

    /*
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

     */
}
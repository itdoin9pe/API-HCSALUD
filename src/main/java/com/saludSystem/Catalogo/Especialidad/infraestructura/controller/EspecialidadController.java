package com.saludSystem.Catalogo.Especialidad.infraestructura.controller;

import com.saludSystem.Catalogo.Especialidad.aplicacion.dtos.ActualizarEspecialidadDTO;
import com.saludSystem.Catalogo.Especialidad.aplicacion.dtos.CrearEspecialidadDTO;
import com.saludSystem.Catalogo.Especialidad.aplicacion.dtos.EspecialidadDTO;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Catalogo.Especialidad.dominio.EspecialidadResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Catalogo.Especialidad.aplicacion.services.EspecialidadService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@Tag(name = "Especialidades")
@RestController
@RequestMapping("/api/Especialidades")
public class EspecialidadController {

    private final EspecialidadService especialidadService;

    public EspecialidadController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    @PostMapping("/SaveEspecialidad")
    public ApiResponse store(@Valid @RequestBody CrearEspecialidadDTO crearEspecialidadDTO){
        return especialidadService.saveEspecialidad(crearEspecialidadDTO);
    }

    @GetMapping("/GetAllEspecialidad")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EspecialidadResponse.class)))
    })
    public ListResponse<EspecialidadDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId, @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return especialidadService.getAllEspecialidad(hospitalId, page, rows);
    }

    @GetMapping("/GetEspecialidadList")
    public ResponseEntity<List<EspecialidadDTO>> getAllList() {
        return ResponseEntity.ok(especialidadService.getEspecialidadList());
    }

    @GetMapping("/GetEspecialidad/{especialidadId}")
    public EspecialidadDTO getById(@PathVariable UUID especialidadId) {
        return especialidadService.getEspecialidadById(especialidadId);
    }

    @PutMapping("/UpdateEspecialidad/{especialidadId}")
    public ApiResponse update(@PathVariable UUID especialidadId, @RequestBody ActualizarEspecialidadDTO actualizarEspecialidadDTO) {
        return especialidadService.updateEspecialidad(especialidadId, actualizarEspecialidadDTO);
    }

    @DeleteMapping("/DeleteEspecialidad/{especialidadId}")
    public ApiResponse destroy(@PathVariable UUID especialidadId) {
        return especialidadService.deleteEspecialidad(especialidadId);
    }

}
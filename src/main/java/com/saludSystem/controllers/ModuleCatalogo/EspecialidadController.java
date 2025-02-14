package com.saludSystem.controllers.ModuleCatalogo;

import com.saludSystem.dtos.catalago.Especialidad.ActualizarEspecialidadDTO;
import com.saludSystem.dtos.catalago.Especialidad.CrearEspecialidadDTO;
import com.saludSystem.dtos.catalago.Especialidad.EspecialidadDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.Catalogo.EspecialidadResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.services.modules.Catalogo.Especialidad.EspecialidadService;
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
    public ListResponse<EspecialidadDTO> getAllPage(@RequestParam(name = "hospitalId", required = true) UUID hospitalId, @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
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

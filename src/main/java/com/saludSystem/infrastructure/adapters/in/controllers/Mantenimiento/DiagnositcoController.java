package com.saludSystem.infrastructure.adapters.in.controllers.Mantenimiento;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarEnfermedadDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearEnfermedadDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.EnfermedadDTO;
import com.saludSystem.application.services.Mantenimiento.EnfermedadService;
import com.saludSystem.infrastructure.adapters.in.response.Mantenimiento.EnfermedadResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Enfermedades")
@RestController
@RequestMapping("/api/Enfermedades")
public class DiagnositcoController {

    private final EnfermedadService enfermedadService;

    public DiagnositcoController(EnfermedadService enfermedadService) {
        this.enfermedadService = enfermedadService;
    }

    @PostMapping("/SaveEnfermedad")
    public ApiResponse stored(@Valid @RequestBody CrearEnfermedadDTO crearEnfermedadDTO) {
        return enfermedadService.saveEnfermedad(crearEnfermedadDTO);
    }

    @GetMapping("/GetAllEnfermedad")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EnfermedadResponse.class)))
    })
    public ListResponse<EnfermedadDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return enfermedadService.getAllEnfermedad(hospitalId, page, rows);
    }

    @GetMapping("/GetEnfermedadList")
    public ResponseEntity<List<EnfermedadDTO>> getAllList() {
        return ResponseEntity.ok(enfermedadService.getEnfermedadList());
    }

    @GetMapping("/GetEnfermedad/{enfermedadId}")
    public EnfermedadDTO getById(@PathVariable String enfermedadId) {
        return enfermedadService.getEnfermedadById(enfermedadId);
    }

    @PutMapping("/UpdateEnfermedad/{enfermedadId}")
    public ApiResponse update(@PathVariable String enfermedadId, @RequestBody ActualizarEnfermedadDTO actualizarEnfermedadDTO) {
        return enfermedadService.updateEnfermedad(enfermedadId, actualizarEnfermedadDTO);
    }

    @DeleteMapping("/DeleteEnfermedad/{enfermedadId}")
    public ApiResponse destroy(@PathVariable String enfermedadId) {
        return enfermedadService.deleteEnfermedad(enfermedadId);
    }

    @GetMapping("/GetEnfermedadFiltradosPorRol")
    public ResponseEntity<List<EnfermedadDTO>> getEnfermedadFiltradosPorRol() {
        return ResponseEntity.ok(enfermedadService.getEnfermedadFiltradosPorRol());
    }

}
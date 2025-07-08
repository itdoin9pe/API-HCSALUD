package com.saludsystem.mantenimiento.infrastructure.adapters.in.controller;

import com.saludsystem.mantenimiento.application.dto.res.EnfermedadDTO;
import com.saludsystem.mantenimiento.application.dto.req.EnfermedadRequest;
import com.saludsystem.mantenimiento.application.dto.res.EnfermedadResponse;
import com.saludsystem.mantenimiento.application.service.EnfermedadService;
import com.saludsystem.mantenimiento.infrastructure.adapters.in.response.EnfermedadListResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
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
    public ApiResponse stored(@Valid @RequestBody EnfermedadRequest enfermedadRequest) {
        return enfermedadService.saveEnfermedad(enfermedadRequest);
    }

    @GetMapping("/GetAllEnfermedad")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EnfermedadListResponse.class)))
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
    public ApiResponse update(@PathVariable String enfermedadId, @RequestBody EnfermedadResponse enfermedadResponse) {
        return enfermedadService.updateEnfermedad(enfermedadId, enfermedadResponse);
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
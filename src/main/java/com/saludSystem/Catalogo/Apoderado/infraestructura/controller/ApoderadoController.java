package com.saludSystem.Catalogo.Apoderado.infraestructura.controller;

import com.saludSystem.Catalogo.Apoderado.aplicacion.dtos.ActualizarApoderadoDTO;
import com.saludSystem.Catalogo.Apoderado.aplicacion.dtos.ApoderadoDTO;
import com.saludSystem.Catalogo.Apoderado.aplicacion.dtos.CrearApoderadoDTO;
import com.saludSystem.Catalogo.Apoderado.aplicacion.services.ApoderadoService;
import com.saludSystem.Catalogo.Apoderado.dominio.ApoderadoResponse;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Apoderados")
@RestController
@RequestMapping("/api/Apoderados")
public class ApoderadoController {

    private final ApoderadoService apoderadoService;

    public ApoderadoController(ApoderadoService apoderadoService) {
        this.apoderadoService = apoderadoService;
    }

    @PostMapping("/SaveApoderado")
    public ApiResponse store(@Valid @RequestBody CrearApoderadoDTO crearApoderadoDTO){
        return apoderadoService.saveApoderado(crearApoderadoDTO);
    }

    @GetMapping("/GetAllApoderado")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApoderadoResponse.class)))
    })
    public ListResponse<ApoderadoDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId, @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return apoderadoService.getAllApoderado(hospitalId, page, rows);
    }

    @GetMapping("/GetApoderado/{apoderadoId}")
    public ApoderadoDTO getById(@PathVariable UUID apoderadoId) {
        return apoderadoService.getApoderadoById(apoderadoId);
    }

    @PutMapping("/UpdateApoderado/{apoderadoId}")
    public ApiResponse update(@PathVariable UUID apoderadoId, @RequestBody ActualizarApoderadoDTO actualizarApoderadoDTOc) {
        return apoderadoService.updateApoderado(apoderadoId, actualizarApoderadoDTOc);
    }

    @DeleteMapping("/DeleteApoderado/{apoderadoId}")
    public ApiResponse destroy(@PathVariable UUID apoderadoId) {
        return apoderadoService.deleteApoderado(apoderadoId);
    }

}
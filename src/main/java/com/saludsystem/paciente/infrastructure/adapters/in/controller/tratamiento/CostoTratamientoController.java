package com.saludsystem.paciente.infrastructure.adapters.in.controller.tratamiento;

import com.saludsystem.paciente.application.dto.get.historialclinico.tratamiento.CostoTratamientoDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.tratamiento.CrearCostoTratamientoDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.tratamiento.ActualizarCostoTratamientoDTO;
import com.saludsystem.paciente.infrastructure.adapters.in.response.Tratamiento.CostoTratamientoListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesCostosTratamientos")
@RestController
@RequestMapping("/api/Pacientes/CostosTratamientos")
public class CostoTratamientoController extends GenericController<CostoTratamientoDTO, CrearCostoTratamientoDTO,
        ActualizarCostoTratamientoDTO, UUID> {

    protected CostoTratamientoController(GenericService<
            CostoTratamientoDTO, CrearCostoTratamientoDTO, ActualizarCostoTratamientoDTO, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CostoTratamientoListResponse.class)))
    })
    public ListResponse<CostoTratamientoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}
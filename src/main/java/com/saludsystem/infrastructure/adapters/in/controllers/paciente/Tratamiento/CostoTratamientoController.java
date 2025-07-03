package com.saludsystem.infrastructure.adapters.in.controllers.paciente.Tratamiento;

import com.saludsystem.application.dtos.paciente.get.tratamiento.CostoTratamientoDTO;
import com.saludsystem.application.dtos.paciente.post.tratamiento.CrearCostoTratamientoDTO;
import com.saludsystem.application.dtos.paciente.put.tratamiento.ActualizarCostoTratamientoDTO;
import com.saludsystem.application.services.GenericService;
import com.saludsystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.in.response.paciente.Tratamiento.CostoTratamientoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesCostosTratamientos")
@RestController
@RequestMapping("/api/Pacientes/CostosTratamientos")
public class CostoTratamientoController extends GenericController<CostoTratamientoDTO, UUID,
        CrearCostoTratamientoDTO, ActualizarCostoTratamientoDTO> {

    protected CostoTratamientoController(GenericService<CostoTratamientoDTO, UUID,
            CrearCostoTratamientoDTO, ActualizarCostoTratamientoDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CostoTratamientoResponse.class)))
    })
    public ListResponse<CostoTratamientoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}
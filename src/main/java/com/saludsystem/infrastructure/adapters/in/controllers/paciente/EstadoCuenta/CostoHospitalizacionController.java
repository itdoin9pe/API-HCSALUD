package com.saludsystem.infrastructure.adapters.in.controllers.paciente.EstadoCuenta;

import com.saludsystem.application.dtos.paciente.get.estadocuenta.CostoHospitalizacionDTO;
import com.saludsystem.application.dtos.paciente.post.estadocuenta.CrearCostoHospitalizacionDTO;
import com.saludsystem.application.dtos.paciente.put.estadocuenta.ActualizarCostoHospitalizacionDTO;
import com.saludsystem.application.services.GenericService;
import com.saludsystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.in.response.paciente.EstadoCuenta.CostoHospitalizacionResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesEstadosCuentasCostosHospitalizaciones")
@RestController
@RequestMapping("/api/Pacientes/EstadosCuentas/CostosHospitalizaciones")
public class CostoHospitalizacionController extends GenericController<CostoHospitalizacionDTO, UUID,
        CrearCostoHospitalizacionDTO, ActualizarCostoHospitalizacionDTO> {

    protected CostoHospitalizacionController(GenericService<CostoHospitalizacionDTO, UUID,
            CrearCostoHospitalizacionDTO, ActualizarCostoHospitalizacionDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CostoHospitalizacionResponse.class)))
    })
    public ListResponse<CostoHospitalizacionDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}
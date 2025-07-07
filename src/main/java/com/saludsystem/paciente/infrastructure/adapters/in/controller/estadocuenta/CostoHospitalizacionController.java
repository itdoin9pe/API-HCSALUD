package com.saludsystem.paciente.infrastructure.adapters.in.controller.estadocuenta;

import com.saludsystem.paciente.application.dto.res.historialclinico.estadocuenta.CostoHospitalizacionDTO;
import com.saludsystem.paciente.application.dto.req.historialclinico.estadocuenta.CrearCostoHospitalizacionDTO;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.paciente.infrastructure.adapters.in.response.EstadoCuenta.CostoHospitalizacionResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesEstadosCuentasCostosHospitalizaciones")
@RestController
@RequestMapping("/api/Pacientes/EstadosCuentas/CostosHospitalizaciones")
public class CostoHospitalizacionController extends GenericController<CrearCostoHospitalizacionDTO,
        CostoHospitalizacionDTO, UUID> {

    protected CostoHospitalizacionController(GenericService<CrearCostoHospitalizacionDTO, CostoHospitalizacionDTO, UUID> genericService) {
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
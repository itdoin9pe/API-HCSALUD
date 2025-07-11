package com.saludsystem.infrastructure.web.restclient.paciente.historialclinico.estadocuenta;

import com.saludsystem.application.dto.get.historialclinico.estadocuenta.CostoHospitalizacionDTO;
import com.saludsystem.application.dto.post.historialclinico.estadocuenta.CrearCostoHospitalizacionDTO;
import com.saludsystem.application.dto.put.historialclinico.estadocuenta.ActualizarCostoHospitalizacionDTO;
import com.saludsystem.infrastructure.adapters.in.response.estadocuenta.CostoHospitalizacionListResponse;
import com.configuracion.application.services.GenericService;
import com.configuracion.infrastructure.adapters.in.controller.GenericController;
import com.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesEstadosCuentasCostosHospitalizaciones")
@RestController
@RequestMapping("/api/Pacientes/EstadosCuentas/CostosHospitalizaciones")
public class CostoHospitalizacionController extends GenericController<CostoHospitalizacionDTO, CrearCostoHospitalizacionDTO,
        ActualizarCostoHospitalizacionDTO, UUID> {

    protected CostoHospitalizacionController(GenericService<
                CostoHospitalizacionDTO, CrearCostoHospitalizacionDTO, ActualizarCostoHospitalizacionDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CostoHospitalizacionListResponse.class)))
    })
    public ListResponse<CostoHospitalizacionDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}
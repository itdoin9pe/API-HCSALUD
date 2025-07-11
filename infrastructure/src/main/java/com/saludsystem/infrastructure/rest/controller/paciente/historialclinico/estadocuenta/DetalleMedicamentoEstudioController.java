package com.saludsystem.infrastructure.rest.controller.paciente.historialclinico.estadocuenta;

import com.saludsystem.application.dto.get.historialclinico.estadocuenta.DetalleMedicamentoEstudioDTO;
import com.saludsystem.application.dto.post.historialclinico.estadocuenta.CrearDetalleMedicamentoEstudioDTO;
import com.saludsystem.application.dto.put.historialclinico.estadocuenta.ActualizarDetalleMedicamentoEstudioDTO;
import com.saludsystem.infrastructure.adapters.in.response.estadocuenta.DetalleMedicamentoEstudioListResponse;
import com.configuracion.application.services.GenericService;
import com.configuracion.infrastructure.adapters.in.controller.GenericController;
import com.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesEstadosCuentasEstudiosDetallesMedicamentos")
@RestController
@RequestMapping("/api/Pacientes/EstadosCuentas/EstudiosDetallesMedicamentos")
public class DetalleMedicamentoEstudioController extends GenericController<DetalleMedicamentoEstudioDTO,
        CrearDetalleMedicamentoEstudioDTO, ActualizarDetalleMedicamentoEstudioDTO, UUID> {

    protected DetalleMedicamentoEstudioController(
            GenericService<DetalleMedicamentoEstudioDTO, CrearDetalleMedicamentoEstudioDTO,
                                ActualizarDetalleMedicamentoEstudioDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DetalleMedicamentoEstudioListResponse.class)))
    })
    public ListResponse<DetalleMedicamentoEstudioDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}
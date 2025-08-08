package com.saludsystem.submodules.core.paciente.rest.controller.query.estadocuenta;

import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.CostoHospitalizacionDTO;
import com.saludsystem.submodules.paciente.query.getAll.estadocuenta.CostoHospitalizacionAllHandler;
import com.saludsystem.submodules.paciente.query.getById.estadocuenta.CostoHospitalizacionByIdHandler;
import com.saludsystem.submodules.paciente.query.getList.estadocuenta.CostoHospitalizacionListHandler;
import com.saludsystem.submodules.paciente.response.estadocuenta.CostoHospitalizacionListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Tag(name = "PacientesEstadosCuentasCostosHospitalizaciones")
@RestController
@RequestMapping("/api/Pacientes/EstadosCuentas/CostosHospitalizaciones")
public class CostoHospitalizacionQueryController {

    private final CostoHospitalizacionListHandler listHandler;
    private final CostoHospitalizacionByIdHandler byIdHandler;
    private final CostoHospitalizacionAllHandler allHandler;

    public CostoHospitalizacionQueryController(CostoHospitalizacionListHandler listHandler, CostoHospitalizacionByIdHandler byIdHandler, CostoHospitalizacionAllHandler allHandler) {
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetList")
    public List<CostoHospitalizacionDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetDoctor/{doctorId}")
    public CostoHospitalizacionDTO getById(@PathVariable UUID doctorId) {
        return byIdHandler.execute(doctorId);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CostoHospitalizacionListResponse.class)))
    })
    public ListResponse<CostoHospitalizacionDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}
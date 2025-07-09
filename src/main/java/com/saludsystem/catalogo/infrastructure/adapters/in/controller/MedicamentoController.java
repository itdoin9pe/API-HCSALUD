package com.saludsystem.catalogo.infrastructure.adapters.in.controller;

import com.saludsystem.catalogo.application.dtos.get.MedicamentoDTO;
import com.saludsystem.catalogo.application.dtos.post.CrearMedicamentoDTO;
import com.saludsystem.catalogo.application.dtos.put.ActualizarMedicamentoDTO;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.catalogo.infrastructure.adapters.in.response.MedicamentoListResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Medicamentos")
@RestController
@RequestMapping("/api/Medicamentos")
public class MedicamentoController extends GenericController<MedicamentoDTO, CrearMedicamentoDTO,
        ActualizarMedicamentoDTO, UUID> {

    protected MedicamentoController(GenericService<MedicamentoDTO, CrearMedicamentoDTO, ActualizarMedicamentoDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MedicamentoListResponse.class)))
    })
    public ListResponse<MedicamentoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}
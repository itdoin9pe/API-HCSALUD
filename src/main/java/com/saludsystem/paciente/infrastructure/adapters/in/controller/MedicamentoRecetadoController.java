package com.saludsystem.paciente.infrastructure.adapters.in.controller;

import com.saludsystem.paciente.application.dto.res.MedicamentoRecetadoDTO;
import com.saludsystem.paciente.application.dto.req.CrearMedicamentoRecetadoDTO;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.paciente.infrastructure.adapters.in.response.MedicamentoRecetadoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesMedicamentosRecetados")
@RestController
@RequestMapping("/api/Pacientes/MedicamentosRecetados")
public class MedicamentoRecetadoController extends GenericController<CrearMedicamentoRecetadoDTO,
        MedicamentoRecetadoDTO, UUID> {

    protected MedicamentoRecetadoController(GenericService<CrearMedicamentoRecetadoDTO, MedicamentoRecetadoDTO, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MedicamentoRecetadoResponse.class)))
    })
    public ListResponse<MedicamentoRecetadoDTO> getAllPaginated(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}
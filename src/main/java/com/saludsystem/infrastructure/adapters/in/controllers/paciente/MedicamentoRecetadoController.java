package com.saludsystem.infrastructure.adapters.in.controllers.paciente;

import com.saludsystem.application.dtos.paciente.get.MedicamentoRecetadoDTO;
import com.saludsystem.application.dtos.paciente.post.CrearMedicamentoRecetadoDTO;
import com.saludsystem.application.dtos.paciente.put.ActualizarMedicamentoRecetadoDTO;
import com.saludsystem.application.services.GenericService;
import com.saludsystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.in.response.paciente.MedicamentoRecetadoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesMedicamentosRecetados")
@RestController
@RequestMapping("/api/Pacientes/MedicamentosRecetados")
public class MedicamentoRecetadoController extends GenericController<MedicamentoRecetadoDTO, UUID,
        CrearMedicamentoRecetadoDTO, ActualizarMedicamentoRecetadoDTO> {

    protected MedicamentoRecetadoController(GenericService<MedicamentoRecetadoDTO, UUID,
            CrearMedicamentoRecetadoDTO, ActualizarMedicamentoRecetadoDTO> genericService) {
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
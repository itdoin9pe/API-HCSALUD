package com.saludsystem.submodules.rest.controller.paciente;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "PacientesMedicamentosRecetados")
@RestController
@RequestMapping("/api/Pacientes/MedicamentosRecetados")
public class MedicamentoRecetadoController {

    /*
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MedicamentoRecetadoListResponse.class)))
    })
    public ListResponse<MedicamentoRecetadoDTO> getAllPaginated(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

     */
}
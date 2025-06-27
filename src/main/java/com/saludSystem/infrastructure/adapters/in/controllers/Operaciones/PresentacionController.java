package com.saludSystem.infrastructure.adapters.in.controllers.Operaciones;

import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarPresentacionDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearPresentacionDTO;
import com.saludSystem.application.dtos.Operaciones.GET.PresentacionDTO;
import com.saludSystem.infrastructure.adapters.in.response.Operaciones.PresentacionResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Presentaciones")
@RestController
@RequestMapping("/api/Presentaciones")
public class PresentacionController extends GenericController<PresentacionDTO, UUID, CrearPresentacionDTO, ActualizarPresentacionDTO> {

    protected PresentacionController(GenericService<PresentacionDTO, UUID, CrearPresentacionDTO, ActualizarPresentacionDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PresentacionResponse.class)))
    })
    public ListResponse<PresentacionDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}
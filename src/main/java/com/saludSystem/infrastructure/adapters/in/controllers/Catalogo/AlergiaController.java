package com.saludSystem.infrastructure.adapters.in.controllers.Catalogo;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarAlergiaDTO;
import com.saludSystem.application.dtos.Catalogo.GET.AlergiaDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearAlergiaDTO;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.Catalogo.AlergiaResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.services.Catalogo.AlergiaService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Alergias")
@RestController
@RequestMapping("/api/Alergias")
public class AlergiaController extends GenericController<AlergiaDTO, UUID, CrearAlergiaDTO, ActualizarAlergiaDTO> {
    private final AlergiaService alergiaService;

    public AlergiaController(
            GenericService<AlergiaDTO, UUID,
            CrearAlergiaDTO, ActualizarAlergiaDTO> genericService,
            AlergiaService alergiaService) {
        super(genericService);
        this.alergiaService = alergiaService;
    }

    @Override
    @PostMapping("/SaveAlergia")
    public ApiResponse create(@Valid @RequestBody CrearAlergiaDTO crearAlergiaDTO) {
        return super.create(crearAlergiaDTO);
    }

    @Override
    @GetMapping("/GetAllAlergia")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AlergiaResponse.class)))
    })
    public ListResponse<AlergiaDTO> getAllPaginated(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return alergiaService.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @GetMapping("/GetAlergiaList")
    public ResponseEntity<List<AlergiaDTO>> getList() {
        return super.getList();
    }

    @Override
    @GetMapping("/GetAlergia/{alergiaId}")
    public AlergiaDTO getById(@PathVariable UUID alergiaId) {
        return alergiaService.getById(alergiaId);
    }

    @Override
    @PutMapping("/UpdateAlergia/{alergiaId}")
    public ApiResponse update(@PathVariable UUID alergiaId, @RequestBody ActualizarAlergiaDTO actualizarAlergiaDTO) {
        return alergiaService.update(alergiaId, actualizarAlergiaDTO);
    }

    @Override
    @DeleteMapping("/DeleteAlergia/{alergiaId}")
    public ApiResponse delete(@PathVariable UUID alergiaId) {
        return super.delete(alergiaId);
    }
}
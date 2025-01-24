package com.saludSystem.controllers.ModuleConfiguracion;

import com.saludSystem.dtos.configuration.Sede.CrearSedeDTO;
import com.saludSystem.dtos.configuration.Sede.SedeDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.Configuration.SedeResponse;
import com.saludSystem.services.modules.configuration.Sede.SedeService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Tag(name = "Sedes")
@RestController
@RequestMapping("/api/Sedes")
public class SedeController {

    private final SedeService sedeService;

    public SedeController(SedeService sedeService){
        this.sedeService = sedeService;
    }

    @PostMapping("/SaveSede")
    public ResponseEntity<ApiResponse> store(@Valid @RequestBody CrearSedeDTO crearSedeDTO){
        sedeService.saveSede(crearSedeDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Sede registrada con exito"));
    }

    @GetMapping("/GetAllSede")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SedeResponse.class)))
    })
    public ResponseEntity<Map<String, Object>> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows
    )
    {
        List<SedeDTO> sedes = sedeService.getPagedResults(hospitalId, page, rows);
        long totalData = sedeService.getTotalCount();
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("data", sedes);
        response.put("totalData", totalData);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/UpdateSede/{id}")
    public ResponseEntity<SedeDTO> update(
            @PathVariable UUID id,
            @RequestBody SedeDTO sedeDTO
    ){
        SedeDTO updatedSede = sedeService.updateSede(id, sedeDTO);
        return ResponseEntity.ok(updatedSede);
    }


    @DeleteMapping("/DeleteSede/{id}")
    public ResponseEntity<ApiResponse> destroy(@PathVariable UUID id){
        sedeService.deleteSede(id);
        return ResponseEntity.ok(new ApiResponse(true, "Sede eliminada con exito"));
    }

    @GetMapping("/GetSede/{id}")
    public ResponseEntity<SedeDTO> getById(@PathVariable UUID id){
        return sedeService.getSedeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("GetSedeList")
    public ResponseEntity<List<SedeDTO>> getAllList()
    {
        return ResponseEntity.ok(sedeService.getSedeList());
    }

}

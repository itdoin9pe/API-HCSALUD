package com.saludSystem.controllers.ModuleCatalogo;

import com.saludSystem.dtos.catalago.Plan.CrearPlanDTO;
import com.saludSystem.dtos.catalago.Plan.PlanDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.Catalogo.PlanResponse;
import com.saludSystem.dtos.responses.Generals.AseguradoraResponse;
import com.saludSystem.services.modules.Catalogo.Plan.PlanService;
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

@Tag(name = "Planes")
@RestController
@RequestMapping("/api/Planes")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService){
        this.planService = planService;
    }

    @PostMapping("/SavePlan")
    public ResponseEntity<ApiResponse> store(@Valid @RequestBody CrearPlanDTO crearPlanDTO){
        planService.savePlan(crearPlanDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Plan creado correctamente"));
    }

    @GetMapping("/GetAllPlan")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PlanResponse.class)))
    })
    public ResponseEntity<Map<String, Object>> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows
    ){
        List<PlanDTO> planes = planService.getPagedResults(hospitalId, page, rows);
        long totalData = planService.getTotalCount();

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("data", planes);
        response.put("totalData", totalData);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/DeletePlan")
    public ResponseEntity<ApiResponse> destroy(@PathVariable UUID planId){
        planService.deletePlan(planId);
        return ResponseEntity.ok(new ApiResponse(true, "Plan eliminado correctamente"));
    }

    @PutMapping("/UpdatePlan/{planId}")
    public ResponseEntity<PlanDTO> update(
            @PathVariable UUID planId,
            @RequestBody PlanDTO planDTO
    ){
        PlanDTO updatedPlan = planService.updatePlan(planId, planDTO);
        return ResponseEntity.ok(updatedPlan);
    }

    @GetMapping("/GetPlan/{planId}")
    public ResponseEntity<PlanDTO> getById(@PathVariable UUID planId) {
        return planService.getPlanById(planId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

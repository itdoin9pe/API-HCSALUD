package com.saludSystem.Catalogo.Plan.infraestructura.controller;

import com.saludSystem.Catalogo.Plan.aplicacion.dtos.ActualizarPlanDTO;
import com.saludSystem.Catalogo.Plan.aplicacion.dtos.CrearPlanDTO;
import com.saludSystem.Catalogo.Plan.aplicacion.dtos.PlanDTO;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Catalogo.Plan.dominio.PlanResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Catalogo.Plan.aplicacion.services.PlanService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
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
    public ApiResponse store(@Valid @RequestBody CrearPlanDTO crearPlanDTO) {
        return planService.savePlan(crearPlanDTO);
    }

    @GetMapping("/GetAllPlan")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PlanResponse.class)))
    })
    public ListResponse<PlanDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows
    ) {
        return planService.getAllPlan(hospitalId, page, rows);
    }

    @DeleteMapping("/DeletePlan/{planId}")
    public ApiResponse destroy(@PathVariable UUID planId){
        return planService.deletePlan(planId);
    }

    @PutMapping("/UpdatePlan/{planId}")
    public ApiResponse update(@PathVariable UUID planId, @RequestBody ActualizarPlanDTO actualizarPlanDTO) {
        return planService.updatePlan(planId, actualizarPlanDTO);
    }

    @GetMapping("/GetPlan/{planId}")
    public PlanDTO getById(@PathVariable UUID planId) {
        return planService.getPlanById(planId);
    }

}
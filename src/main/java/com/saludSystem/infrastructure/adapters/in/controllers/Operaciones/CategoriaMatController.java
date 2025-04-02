package com.saludSystem.infrastructure.adapters.in.controllers.Operaciones;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarCategoriaMatDTO;
import com.saludSystem.application.dtos.Operaciones.GET.CategoriaMatDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearCategotiaMatDTO;
import com.saludSystem.application.services.Operaciones.CategoriaMatService;
import com.saludSystem.infrastructure.adapters.in.response.Operaciones.CategoriaMatResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "CategoriasMateriales")
@RestController
@RequestMapping("/api/CategoriasMateriales")
public class CategoriaMatController {

    private final CategoriaMatService categoriaMatService;

    public CategoriaMatController(CategoriaMatService categoriaMatService) {
        this.categoriaMatService = categoriaMatService;
    }

    @PostMapping("/SaveCategoriaMaterial")
    public ApiResponse stored(@Valid @RequestBody CrearCategotiaMatDTO crearCategotiaMatDTO) {
        return categoriaMatService.saveCategoriaMaterial(crearCategotiaMatDTO);
    }

    @GetMapping("/GetAllCategoriaMaterial")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoriaMatResponse.class)))
    })
    public ListResponse<CategoriaMatDTO> getAllPage
            (@RequestParam(name = "hospitalId") UUID hospitalId,
             @RequestParam(name = "Page", defaultValue = "") int page,
             @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return categoriaMatService.getAllCategoriaMaterial(hospitalId, page, rows);
    }

    @GetMapping("/GetCategoriaMaterial/{categoriaMaterialId}")
    public CategoriaMatDTO getById(@PathVariable UUID categoriaMaterialId) {
        return categoriaMatService.getCategoriaMaterialById(categoriaMaterialId);
    }

    @PutMapping("/UpdateCategoriaMaterial/{categoriaMaterialId}")
    public ApiResponse update(@PathVariable UUID categoriaMaterialId, @RequestBody ActualizarCategoriaMatDTO actualizarCategoriaMatDTO) {
        return categoriaMatService.updateCategoriaMaterial(categoriaMaterialId, actualizarCategoriaMatDTO);
    }

    @DeleteMapping("/DeleteCategoriaMaterial/{categoriaMaterialId}")
    public ApiResponse destroy(@PathVariable UUID categoriaMaterialId) {
        return categoriaMatService.deleteCategoriaMaterial(categoriaMaterialId);
    }

    @GetMapping("/GetCategoriaMaterialList")
    public ResponseEntity<List<CategoriaMatDTO>> getAllList() {
        return ResponseEntity.ok(categoriaMatService.getCategoriaMaterialList());
    }

}
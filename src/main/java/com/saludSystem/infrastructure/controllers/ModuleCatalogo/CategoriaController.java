package com.saludSystem.infrastructure.controllers.ModuleCatalogo;
/*
import com.saludSystem.dtos.catalago.Categoria.ActualizarCategoriaDTO;
import com.saludSystem.dtos.catalago.Categoria.CategoriaDTO;
import com.saludSystem.dtos.catalago.Categoria.CrearCategoriaDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.Catalogo.CategoriaResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.services.modules.Catalogo.Categoria.CategoriaService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Categorias")
@RestController
@RequestMapping("/api/Categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/SaveCategoria")
    public ResponseEntity<ApiResponse> store(@Valid @RequestBody CrearCategoriaDTO crearCategoriaDTO) {
        categoriaService.saveCategoria(crearCategoriaDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Categoria creada correctamente."));
    }

    @GetMapping("/GetAllCategoria")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoriaResponse.class)))
    })
    public ResponseEntity<ListResponse<CategoriaDTO>> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        List<CategoriaDTO> categorias = categoriaService.getPagedResults(hospitalId, page, rows);
        long totalData = categoriaService.getTotalCount();
        ListResponse<CategoriaDTO> response = new ListResponse<>();
        response.setData(categorias);
        response.setTotalData(totalData);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/GetCategoriaList")
    public ResponseEntity<List<CategoriaDTO>> getAllList() {
        return ResponseEntity.ok(categoriaService.getCategoriaList());
    }

    @GetMapping("/GetCategoria/{categoriaId}")
    public ResponseEntity<CategoriaDTO> getById(@PathVariable UUID categoriaId) {
        return categoriaService.getCategoriaById(categoriaId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/UpdateCategoria/{categoriaId}")
    public ResponseEntity<ApiResponse> update(@PathVariable UUID categoriaId, @RequestBody ActualizarCategoriaDTO actualizarCategoriaDTO) {
        categoriaService.updateCategoria(categoriaId, actualizarCategoriaDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Categoria actualizado correctamente"));
    }

    @DeleteMapping("/DeleteCategoria/{categoriaId}")
    public ResponseEntity<ApiResponse> destroy(@PathVariable UUID categoriaId) {
        categoriaService.deleteCategoria(categoriaId);
        return ResponseEntity.ok(new ApiResponse(true, "Categoria eliminada correctamente,"));
    }

}*/


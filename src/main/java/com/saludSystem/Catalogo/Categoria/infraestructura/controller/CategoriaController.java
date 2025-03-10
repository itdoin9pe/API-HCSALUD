    package com.saludSystem.Catalogo.Categoria.infraestructura.controller;

    import com.saludSystem.Catalogo.Categoria.aplicacion.dtos.ActualizarCategoriaDTO;
    import com.saludSystem.Catalogo.Categoria.aplicacion.dtos.CategoriaDTO;
    import com.saludSystem.Catalogo.Categoria.aplicacion.dtos.CrearCategoriaDTO;
    import com.saludSystem.Generals.response.ApiResponse;
    import com.saludSystem.Catalogo.Categoria.dominio.CategoriaResponse;
    import com.saludSystem.Generals.response.ListResponse;
    import com.saludSystem.Catalogo.Categoria.aplicacion.services.CategoriaService;
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
        public ApiResponse store(@Valid @RequestBody CrearCategoriaDTO crearCategoriaDTO) {
            return categoriaService.saveCategoria(crearCategoriaDTO);
        }

        @GetMapping("/GetAllCategoria")
        @ApiResponses(value = {
                @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                        content = @Content(mediaType = "application/json",
                                schema = @Schema(implementation = CategoriaResponse.class)))
        })
        public ListResponse<CategoriaDTO> getAllPage(
                @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
                @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
            return categoriaService.getAllCategoria(hospitalId, page, rows);
        }

        @GetMapping("/GetCategoriaList")
        public ResponseEntity<List<CategoriaDTO>> getAllList() {
            return ResponseEntity.ok(categoriaService.getCategoriaList());
        }

        @GetMapping("/GetCategoria/{categoriaId}")
        public CategoriaDTO getById(@PathVariable UUID categoriaId) {
            return categoriaService.getCategoriaById(categoriaId);
        }

        @PutMapping("/UpdateCategoria/{categoriaId}")
        public ApiResponse update(@PathVariable UUID categoriaId, @RequestBody ActualizarCategoriaDTO actualizarCategoriaDTO) {
            return categoriaService.updateCategoria(categoriaId, actualizarCategoriaDTO);
        }

        @DeleteMapping("/DeleteCategoria/{categoriaId}")
        public ApiResponse destroy(@PathVariable UUID categoriaId) {
            return categoriaService.deleteCategoria(categoriaId);
        }

    }
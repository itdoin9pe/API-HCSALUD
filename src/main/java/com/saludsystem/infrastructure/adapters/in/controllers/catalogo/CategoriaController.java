    package com.saludsystem.infrastructure.adapters.in.controllers.catalogo;

    import com.saludsystem.application.dtos.catalogo.req.CategoriaDTO;
    import com.saludsystem.application.dtos.catalogo.post.CrearCategoriaDTO;
    import com.saludsystem.application.services.GenericService;
    import com.saludsystem.infrastructure.adapters.in.controllers.GenericController;
    import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
    import com.saludsystem.infrastructure.adapters.in.response.catalogo.CategoriaResponse;
    import io.swagger.v3.oas.annotations.media.Content;
    import io.swagger.v3.oas.annotations.media.Schema;
    import io.swagger.v3.oas.annotations.responses.ApiResponses;
    import io.swagger.v3.oas.annotations.tags.Tag;
    import org.springframework.web.bind.annotation.*;

    import java.util.UUID;

    @Tag(name = "Categorias")
    @RestController
    @RequestMapping("/api/Categorias")
    public class CategoriaController extends GenericController<CrearCategoriaDTO, CategoriaDTO, UUID> {

        protected CategoriaController(GenericService<CrearCategoriaDTO, CategoriaDTO, UUID> genericService) {
            super(genericService);
        }

        @GetMapping("/GetAll")
        @ApiResponses(value = {
                @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                        description = "Operación exitosa", content = @Content(mediaType = "application/json",
                                schema = @Schema(implementation = CategoriaResponse.class)))
        })
        public ListResponse<CategoriaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
            return super.getAllPaginated(hospitalId, page, rows);
        }
    }
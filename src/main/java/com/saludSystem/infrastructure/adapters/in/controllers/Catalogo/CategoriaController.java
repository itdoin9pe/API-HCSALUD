    package com.saludSystem.infrastructure.adapters.in.controllers.Catalogo;

    import com.saludSystem.application.dtos.Catalogo.GET.CategoriaDTO;
    import com.saludSystem.application.dtos.Catalogo.POST.CrearCategoriaDTO;
    import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarCategoriaDTO;
    import com.saludSystem.application.services.GenericService;
    import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
    import com.saludSystem.infrastructure.adapters.in.response.Catalogo.CategoriaResponse;
    import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
    import io.swagger.v3.oas.annotations.media.Content;
    import io.swagger.v3.oas.annotations.media.Schema;
    import io.swagger.v3.oas.annotations.responses.ApiResponses;
    import io.swagger.v3.oas.annotations.tags.Tag;
    import org.springframework.web.bind.annotation.*;

    import java.util.UUID;

    @Tag(name = "Categorias")
    @RestController
    @RequestMapping("/api/Categorias")
    public class CategoriaController extends GenericController<CategoriaDTO, UUID,
            CrearCategoriaDTO, ActualizarCategoriaDTO> {
        protected CategoriaController(GenericService<CategoriaDTO, UUID,
                CrearCategoriaDTO, ActualizarCategoriaDTO> genericService) {
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
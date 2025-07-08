    package com.saludsystem.catalogo.infrastructure.adapters.in.controller;

    import com.saludsystem.catalogo.application.dtos.res.CategoriaRequest;
    import com.saludsystem.shared.application.service.GenericService;
    import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
    import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
    import com.saludsystem.catalogo.infrastructure.adapters.in.response.CategoriaListResponse;
    import io.swagger.v3.oas.annotations.media.Content;
    import io.swagger.v3.oas.annotations.media.Schema;
    import io.swagger.v3.oas.annotations.responses.ApiResponses;
    import io.swagger.v3.oas.annotations.tags.Tag;
    import org.springframework.web.bind.annotation.*;

    import java.util.UUID;

    @Tag(name = "Categorias")
    @RestController
    @RequestMapping("/api/Categorias")
    public class CategoriaController extends GenericController<com.saludsystem.catalogo.application.dtos.req.CategoriaRequest, CategoriaRequest, UUID> {

        protected CategoriaController(GenericService<com.saludsystem.catalogo.application.dtos.req.CategoriaRequest, CategoriaRequest, UUID> genericService) {
            super(genericService);
        }

        @GetMapping("/GetAll")
        @ApiResponses(value = {
                @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                        description = "Operación exitosa", content = @Content(mediaType = "application/json",
                                schema = @Schema(implementation = CategoriaListResponse.class)))
        })
        public ListResponse<CategoriaRequest> getAllPaginated(UUID hospitalId, int page, int rows) {
            return super.getAllPaginated(hospitalId, page, rows);
        }
    }
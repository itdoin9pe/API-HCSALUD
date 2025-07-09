    package com.saludsystem.catalogo.infrastructure.adapters.in.controller;

    import com.saludsystem.catalogo.application.dtos.get.CategoriaDTO;
    import com.saludsystem.catalogo.application.dtos.post.CrearCategoriaDTO;
    import com.saludsystem.catalogo.application.dtos.put.ActualizarCategoriaDTO;
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
    public class CategoriaController extends GenericController<CategoriaDTO, CrearCategoriaDTO,
            ActualizarCategoriaDTO, UUID> {

        protected CategoriaController(GenericService<CategoriaDTO, CrearCategoriaDTO, ActualizarCategoriaDTO,
                UUID> genericService) {
            super(genericService);
        }

        @Override
        @GetMapping("/GetAll")
        @ApiResponses(value = {
                @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                        description = "Operación exitosa", content = @Content(mediaType = "application/json",
                                schema = @Schema(implementation = CategoriaListResponse.class)))
        })
        public ListResponse<CategoriaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
            return super.getAllPaginated(hospitalId, page, rows);
        }
    }
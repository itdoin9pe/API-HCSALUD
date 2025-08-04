package com.saludsystem.submodules.core.operaciones.rest.controller.query;

import com.saludsystem.submodules.operaciones.model.dtos.ProductoDTO;
import com.saludsystem.submodules.operaciones.query.getAll.ProductoAllHandler;
import com.saludsystem.submodules.operaciones.query.getById.ProductoByIdHandler;
import com.saludsystem.submodules.operaciones.query.getList.ProductoListHandler;
import com.saludsystem.submodules.operaciones.response.ProductoListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Productos")
@RestController
@RequestMapping("/api/Productos")
@Validated
public class ProductoQueryController {

    private final ProductoAllHandler allHandler;
    private final ProductoListHandler listHandler;
    private final ProductoByIdHandler byIdHandler;

    public ProductoQueryController(ProductoAllHandler allHandler, ProductoListHandler listHandler, ProductoByIdHandler byIdHandler) {
        this.allHandler = allHandler;
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
    }

    @GetMapping("/GetList")
    public List<ProductoDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public ProductoDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAllProducto")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductoListResponse.class)))
    })
    public ListResponse<ProductoDTO> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}

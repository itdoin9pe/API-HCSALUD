package com.saludsystem.submodules.core.movimiento.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.saludsystem.submodules.movimiento.model.dtos.VentaDetalleDTO;
import com.saludsystem.submodules.movimiento.query.getAll.VentaDetalleAllHandler;
import com.saludsystem.submodules.movimiento.query.getById.VentaDetalleByIdHandler;
import com.saludsystem.submodules.movimiento.query.getList.VentaDetalleListHandler;
import com.saludsystem.submodules.movimiento.response.VentaDetalleListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "VentasDetalles")
@RestController
@RequestMapping("/api/VentasDetalles")
public class VentaDetalleQueryController {

	private final VentaDetalleListHandler listHandler;
	private final VentaDetalleByIdHandler byIdHandler;
	private final VentaDetalleAllHandler allHandler;

	/**
	 * @param listHandler
	 * @param byIdHandler
	 * @param allHandler
	 */
	public VentaDetalleQueryController(VentaDetalleListHandler listHandler, VentaDetalleByIdHandler byIdHandler,
			VentaDetalleAllHandler allHandler) {
		this.listHandler = listHandler;
		this.byIdHandler = byIdHandler;
		this.allHandler = allHandler;
	}

	 @GetMapping("/GetList")
	    public List<VentaDetalleDTO> getList() {
	        return listHandler.execute();
	    }

	    @GetMapping("/GetById/{ventaDetalleId}")
	    public VentaDetalleDTO getById(@PathVariable UUID ventaDetalleId) {
	        return byIdHandler.execute(ventaDetalleId);
	    }

	    @GetMapping("/GetAll")
	    @ApiResponses(value = {
	            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
	                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
	                    schema = @Schema(implementation = VentaDetalleListResponse.class)))
	    })
	    public ListResponse<VentaDetalleDTO> getAll(@RequestParam UUID hospitalId,
	                                           @RequestParam(name = "Page") int page,
	                                           @RequestParam(name = "Rows") int rows) {
	        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
	    }
	    
}

package com.saludsystem.submodules.core.movimiento.rest.controller.query;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.saludsystem.submodules.movimiento.model.dtos.AlmacenDTO;
import com.saludsystem.submodules.movimiento.query.getAll.AlmacenAllHandler;
import com.saludsystem.submodules.movimiento.query.getById.AlmacenByIdHandler;
import com.saludsystem.submodules.movimiento.query.getList.AlmacenListHandler;
import com.saludsystem.submodules.movimiento.response.AlmacenListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Tag(name = "Almacenes")
@RestController
@RequestMapping("/api/Almacenes")
public class AlmacenQueryController {

	private final AlmacenAllHandler allHandler;
	private final AlmacenByIdHandler byIdHandler;
	private final AlmacenListHandler listHandler;
	
    /**
	 * @param allHandler
	 * @param byIdHandler
	 * @param listHandler
	 */
	public AlmacenQueryController(AlmacenAllHandler allHandler, AlmacenByIdHandler byIdHandler,
			AlmacenListHandler listHandler) {
		this.allHandler = allHandler;
		this.byIdHandler = byIdHandler;
		this.listHandler = listHandler;
	}

    @GetMapping("/GetList")
    public List<AlmacenDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{almacenId}")
    public AlmacenDTO getById(@PathVariable UUID almacenId) {
        return byIdHandler.execute(almacenId);
    }

	@GetMapping("/GetAll")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AlmacenListResponse.class)))
    })
    public ListResponse<AlmacenDTO> getAllPaginated(
    		@RequestParam UUID hospitalId,
            @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }
	
}

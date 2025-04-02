package com.saludSystem.infrastructure.adapters.in.controllers.Catalogo;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarClienteDTO;
import com.saludSystem.application.dtos.Catalogo.GET.ClienteDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearClienteDTO;
import com.saludSystem.application.services.Catalogo.ClienteService;
import com.saludSystem.infrastructure.adapters.in.response.Catalogo.ClienteResponse;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Clientes")
@RestController
@RequestMapping("/api/Clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/SaveCliente")
    public ApiResponse store(@Valid @RequestBody CrearClienteDTO crearClienteDTO){
        return clienteService.saveCliente(crearClienteDTO);
    }

    @GetMapping("/GetAllCliente")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClienteResponse.class)))
    })
    public ListResponse<ClienteDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId, @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return clienteService.getAllCliente(hospitalId, page, rows);
    }

    @GetMapping("/GetCliente/{clienteId}")
    public ClienteDTO getById(@PathVariable UUID clienteId) {
        return clienteService.getClienteById(clienteId);
    }

    @PutMapping("/UpdateCliente/{clienteId}")
    public ApiResponse update(@PathVariable UUID clienteId, @RequestBody ActualizarClienteDTO actualizarClienteDTO) {
        return clienteService.updateCliente(clienteId, actualizarClienteDTO);
    }

    @DeleteMapping("/DeleteCliente/{clienteId}")
    public ApiResponse destroy(@PathVariable UUID clienteId) {
        return clienteService.deleteCliente(clienteId);
    }

}
package com.saludSystem.controllers.ModuleConfiguracion;

import com.saludSystem.dtos.configuration.SysSaludModule.CrearSysSaludDTO;
import com.saludSystem.dtos.configuration.SysSaludModule.SysSaludDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.Configuration.ClinicaResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.dtos.responses.Paciente.PacienteResponse;
import com.saludSystem.repositories.modules.Catalogo.PlanRepository;
import com.saludSystem.services.modules.configuration.SysSalud.SysSaludService;
import com.saludSystem.util.Util;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Tag(name = "Clinica")
@RestController
@RequestMapping("/api/Clinicas")
public class ClinicaController {

    private final SysSaludService sysSaludService;
    private final PlanRepository planRepository;

    public ClinicaController(SysSaludService sysSaludService, PlanRepository planRepository){
        this.sysSaludService = sysSaludService;
        this.planRepository = planRepository;
    }

    @PostMapping("/SaveClinica")
    public ResponseEntity<ApiResponse> store(
            @RequestParam("nombre") String nombre,
            @RequestParam("direccion") String direccion,
            @RequestParam("celular") String celular,
            @RequestParam("email") String email,
            @RequestParam("ruc") String ruc,
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date fecha,
            @RequestParam("foto") MultipartFile foto,
            //@RequestParam("planId") UUID planId,
            @RequestParam("estado") Integer estado
            ) throws IOException {
        CrearSysSaludDTO crearSysSaludDTO = new CrearSysSaludDTO();
        crearSysSaludDTO.setNombre(nombre);
        crearSysSaludDTO.setDireccion(direccion);
        crearSysSaludDTO.setCelular(celular);
        crearSysSaludDTO.setEmail(email);
        crearSysSaludDTO.setRuc(ruc);
        crearSysSaludDTO.setFecha(fecha);
        crearSysSaludDTO.setFoto(Util.compressZLib(foto.getBytes()));
        //sysSaludDTO.setPlanId(planId);
        crearSysSaludDTO.setEstado(estado);
        sysSaludService.saveClinica(crearSysSaludDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Clinica creada correctamente!!."));

    }

    @GetMapping("/GetAllClinica")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClinicaResponse.class)))
    })
    public ResponseEntity<ListResponse<SysSaludDTO>> getAllPage(
            @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows
    ){
        List<SysSaludDTO> hospitales = sysSaludService.getAllClinica(page, rows);
        long totalData = sysSaludService.getTotalCount();
        ListResponse<SysSaludDTO> response = new ListResponse<>();
        response.setData(hospitales);
        response.setTotalData(totalData);
        return ResponseEntity.ok(response);
    }

}

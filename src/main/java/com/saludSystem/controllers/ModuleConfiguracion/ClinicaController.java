package com.saludSystem.controllers.ModuleConfiguracion;

import com.saludSystem.dtos.configuration.SysSaludDTO;
import com.saludSystem.entities.catalogo.Plan;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Catalogo.PlanRepository;
import com.saludSystem.services.modules.configuration.SysSalud.SysSaludService;
import com.saludSystem.util.Util;
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
    public ResponseEntity<SysSaludDTO> store(
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
        SysSaludDTO sysSaludDTO = new SysSaludDTO();
        sysSaludDTO.setNombre(nombre);
        sysSaludDTO.setDireccion(direccion);
        sysSaludDTO.setCelular(celular);
        sysSaludDTO.setEmail(email);
        sysSaludDTO.setRuc(ruc);
        sysSaludDTO.setFecha(fecha);
        sysSaludDTO.setFoto(Util.compressZLib(foto.getBytes()));
        //sysSaludDTO.setPlanId(planId);
        sysSaludDTO.setEstado(estado);

        sysSaludService.saveClinica(sysSaludDTO);

        return ResponseEntity.ok().build();

    }

    @GetMapping("/GetAllClinica")
    public ResponseEntity<Map<String, Object>> getAllPage(
            @RequestParam(name = "Page", defaultValue = "1") int page,
            @RequestParam(name = "Rows", defaultValue = "10") int rows
    ){
        List<SysSaludDTO> hospitales = sysSaludService.getAllClinica(page, rows);
        long totalData = sysSaludService.getTotalCount();

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("data", hospitales);
        response.put("totalData", totalData);

        return ResponseEntity.ok(response);
    }

}

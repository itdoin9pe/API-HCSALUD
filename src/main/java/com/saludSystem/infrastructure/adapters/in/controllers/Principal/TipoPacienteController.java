package com.saludSystem.infrastructure.adapters.in.controllers.Principal;

import com.saludSystem.application.dtos.Principal.GET.TipoPacienteDTO;
import com.saludSystem.application.services.Principal.TipoPacienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "TiposPaciente")
@RestController
@RequestMapping("/api/TiposPaciente")
public class TipoPacienteController {

    private final TipoPacienteService tipoPacienteService;

    public TipoPacienteController(TipoPacienteService tipoPacienteService) {
        this.tipoPacienteService = tipoPacienteService;
    }

    @GetMapping("/GetTipoPacienteList")
    public ResponseEntity<List<TipoPacienteDTO>> getTipoPacienteList(){
        return ResponseEntity.ok(tipoPacienteService.getTipoPacienteList());
    }

}
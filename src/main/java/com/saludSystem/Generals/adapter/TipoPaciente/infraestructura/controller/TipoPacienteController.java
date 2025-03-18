package com.saludSystem.Generals.adapter.TipoPaciente.infraestructura.controller;

import com.saludSystem.Generals.adapter.TipoPaciente.aplicacion.TipoPacienteDTO;
import com.saludSystem.Generals.adapter.TipoPaciente.aplicacion.services.TipoPacienteService;
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
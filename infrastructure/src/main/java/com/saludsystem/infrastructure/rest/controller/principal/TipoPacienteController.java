package com.saludsystem.infrastructure.rest.controller.principal;

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

    /*
    private final TipoPacienteService tipoPacienteService;

    public TipoPacienteController(TipoPacienteService tipoPacienteService) {
        this.tipoPacienteService = tipoPacienteService;
    }

    @GetMapping("/GetTipoPacienteList")
    public ResponseEntity<List<TipoPacienteDTO>> getTipoPacienteList(){
        return ResponseEntity.ok(tipoPacienteService.getTipoPacienteList());
    }

     */

}
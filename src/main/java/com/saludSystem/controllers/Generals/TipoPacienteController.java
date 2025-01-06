package com.saludSystem.controllers.Generals;

import com.saludSystem.dtos.Generals.TipoPacienteDTO;
import com.saludSystem.services.modules.Generals.TipoPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/TiposPaciente")
public class TipoPacienteController {

    @Autowired
    TipoPacienteService tipoPacienteService;

    @GetMapping("/GetTipoPacienteList")
    public ResponseEntity<List<TipoPacienteDTO>> getTipoPacienteList(){
        List<TipoPacienteDTO> tipoPacientes = tipoPacienteService.getAllTipoPaciente();
        return new ResponseEntity<>(tipoPacientes, HttpStatus.OK);
    }
}

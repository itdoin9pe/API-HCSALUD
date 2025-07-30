package com.saludsystem.submodules.core.principal.rest.controller.query;

import com.saludsystem.submodules.principal.dtos.get.TipoPacienteDTO;
import com.saludsystem.submodules.principal.query.getById.TipoPacienteByIdHandler;
import com.saludsystem.submodules.principal.query.getList.TipoPacienteListHandler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "TiposPaciente")
@RestController
@RequestMapping("/api/TiposPaciente")
public class TipoPacienteQueryController {

    private final TipoPacienteListHandler listHandler;
    private final TipoPacienteByIdHandler byIdHandler;

    public TipoPacienteQueryController(TipoPacienteListHandler listHandler, TipoPacienteByIdHandler byIdHandler) {
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
    }

    @GetMapping("/GetTipoPacienteList")
    public List<TipoPacienteDTO> getList(){
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public TipoPacienteDTO getById(@PathVariable Long id) {
        return byIdHandler.execute(id);
    }

}

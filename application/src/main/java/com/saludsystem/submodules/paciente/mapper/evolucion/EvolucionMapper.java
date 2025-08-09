package com.saludsystem.submodules.paciente.mapper.evolucion;

import com.saludsystem.submodules.paciente.model.dtos.command.create.evolucion.EvolucionCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.create.evolucion.NotaCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.evolucion.EvolucionEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.evolucion.NotaEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.EvolucionDTO;
import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.NotaDTO;
import com.saludsystem.submodules.paciente.model.entity.evolucion.CambioCondicion;
import com.saludsystem.submodules.paciente.model.entity.evolucion.Evolucion;
import com.saludsystem.submodules.paciente.model.entity.evolucion.Nota;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class EvolucionMapper {

    private final NotaMapper notaMapper = new NotaMapper();
    private final CambioCondicionMapper cambioMapper = new CambioCondicionMapper();

    public Evolucion fromCreateDto(EvolucionCreateCommand createCommand) {
        return new Evolucion(
                null, // pacienteEvolucionId -> se genera en persistencia
                createCommand.getPacienteId(),
                createCommand.getFechaInicio(),
                createCommand.getFinalizada() != null ? createCommand.getFinalizada() : false,
                mapNotasFromCreate(createCommand.getNotas()),
                mapCambiosFromCreate(createCommand.getCambios()),
                createCommand.getPacienteAltaMedicaId()
        );
    }

    public Evolucion fromUpdateDto(UUID uuid, EvolucionEditCommand editCommand) {
        return new Evolucion(
                uuid,
                editCommand.getPacienteId(),
                editCommand.getFechaInicio(),
                editCommand.getFinalizada(),
                mapNotasFromUpdate(editCommand.getNotas()),
                mapCambiosFromUpdate(editCommand.getCambios()),
                editCommand.getPacienteAltaMedicaId()
        );
    }

    public EvolucionDTO toDto(Evolucion model) {
        return new EvolucionDTO(
                model.getPacienteEvolucionId(),
                model.getPacienteId(),
                model.getFechaInicio(),
                model.getFinalizada(),
                mapNotasToDto(model.getNotas()),
                mapCambiosToDto(model.getCambios()),
                model.getPacienteAltaMedicaId()
        );
    }

    // ===== Métodos privados de mapeo de listas =====
    private List<Nota> mapNotasFromCreate(List<?> notasCreate) {
        if (notasCreate == null) return null;
        return notasCreate.stream()
                .map(n -> notaMapper.fromCreateDto((NotaCreateCommand) n))
                .collect(Collectors.toList());
    }

    private List<Nota> mapNotasFromUpdate(List<?> notasUpdate) {
        if (notasUpdate == null) return null;
        return notasUpdate.stream()
                .map(n -> {
                    var notaEdit = (NotaEditCommand) n;
                    return notaMapper.fromUpdateDto(notaEdit.getPacienteEvolucionNotaId(), notaEdit);
                })
                .collect(Collectors.toList());
    }

    private List<NotaDTO> mapNotasToDto(List<Nota> notas) {
        if (notas == null) return null;
        return notas.stream()
                .map(notaMapper::toDto)
                .collect(Collectors.toList());
    }

    private List<CambioCondicion> mapCambiosFromCreate(List<?> cambiosCreate) {
        if (cambiosCreate == null) return null;
        return cambiosCreate.stream()
                .map(c -> cambioMapper.fromCreateDto((com.saludsystem.submodules.paciente.model.dtos.command.create.evolucion.CambioCondicionCreateCommand) c))
                .collect(Collectors.toList());
    }

    private List<CambioCondicion> mapCambiosFromUpdate(List<?> cambiosUpdate) {
        if (cambiosUpdate == null) return null;
        return cambiosUpdate.stream()
                .map(c -> {
                    var cambioEdit = (com.saludsystem.submodules.paciente.model.dtos.command.edit.evolucion.CambioCondicionEditCommand) c;
                    return cambioMapper.fromUpdateDto(cambioEdit.getEvolucionCambioCondicionId(), cambioEdit);
                })
                .collect(Collectors.toList());
    }

    private List<com.saludsystem.submodules.paciente.model.dtos.get.evolucion.CambioCondicionDTO> mapCambiosToDto(List<CambioCondicion> cambios) {
        if (cambios == null) return null;
        return cambios.stream()
                .map(cambioMapper::toDto)
                .collect(Collectors.toList());
    }
}
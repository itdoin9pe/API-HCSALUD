package com.saludsystem.submodules.core.paciente.adapter.mapper.evolucion;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.evolucion.AltaMedicaEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.evolucion.CambioCondicionEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.evolucion.EvolucionEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.evolucion.NotaEntity;
import com.saludsystem.submodules.paciente.model.entity.evolucion.CambioCondicion;
import com.saludsystem.submodules.paciente.model.entity.evolucion.Evolucion;
import com.saludsystem.submodules.paciente.model.entity.evolucion.Nota;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class EvolucionDboMapper {

    public static EvolucionEntity toEntity(Evolucion model, UUID userId, UUID hospitalId) {
        EvolucionEntity entity = new EvolucionEntity();

        entity.setPacienteEvolucionId(model.getPacienteEvolucionId());
        entity.setFechaInicio(model.getFechaInicio());
        entity.setFinalizada(model.getFinalizada());

        // Relación con Paciente
        if (model.getPacienteId() != null) {
            PacienteEntity pacienteEntity = new PacienteEntity();
            pacienteEntity.setPacienteId(model.getPacienteId());
            entity.setPacienteEntity(pacienteEntity);
        }

        // Relación con Notas
        if (model.getNotas() != null) {
            List<NotaEntity> notas = model.getNotas().stream().map(nota -> {
                NotaEntity notaEntity = new NotaEntity();
                notaEntity.setId(nota.getId());
                notaEntity.setFecha(nota.getFecha());
                notaEntity.setContenido(nota.getContenido());
                notaEntity.setEvolucionEntity(entity);
                return notaEntity;
            }).collect(Collectors.toList());
            entity.setNotas(notas);
        }

        // Relación con Cambios de Condición
        if (model.getCambios() != null) {
            List<CambioCondicionEntity> cambios = model.getCambios().stream().map(cambio -> {
                CambioCondicionEntity cambioEntity = new CambioCondicionEntity();
                cambioEntity.setId(cambio.getId());
                cambioEntity.setFecha(cambio.getFecha());
                cambioEntity.setDescripcion(cambio.getDescripcion());
                cambioEntity.setEvolucionEntity(entity);
                return cambioEntity;
            }).collect(Collectors.toList());
            entity.setCambios(cambios);
        }

        // Relación con Alta Médica
        if (model.getPacienteAltaMedicaId() != null) {
            AltaMedicaEntity altaEntity = new AltaMedicaEntity();
            altaEntity.setId(model.getPacienteAltaMedicaId());
            altaEntity.setEvolucionEntity(entity);
            entity.setAltaMedica(altaEntity);
        }

        // Auditoría
        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;
    }

    public static Evolucion toDomain(EvolucionEntity entity) {
        return new Evolucion(
                entity.getPacienteEvolucionId(),
                entity.getPacienteEntity() != null ? entity.getPacienteEntity().getPacienteId() : null,
                entity.getFechaInicio(),
                entity.getFinalizada(),
                entity.getNotas() != null ? entity.getNotas().stream()
                        .map(n -> new Nota(
                                n.getId(),
                                n.getFecha(),
                                n.getTipo(),
                                n.getContenido(),
                                entity.getPacienteEvolucionId()
                        ))
                        .collect(Collectors.toList()) : null,
                entity.getCambios() != null ? entity.getCambios().stream()
                        .map(c -> new CambioCondicion(
                                c.getId(),
                                c.getFecha(),
                                c.getDescripcion(),
                                entity.getPacienteEvolucionId()
                        ))
                        .collect(Collectors.toList()) : null,
                entity.getAltaMedica() != null ? entity.getAltaMedica().getId() : null
        );
    }

}

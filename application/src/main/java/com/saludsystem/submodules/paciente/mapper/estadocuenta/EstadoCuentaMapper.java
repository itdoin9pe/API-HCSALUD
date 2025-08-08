package com.saludsystem.submodules.paciente.mapper.estadocuenta;

import com.saludsystem.submodules.paciente.model.dtos.command.create.estadocuenta.EstadoCuentaCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.estadocuenta.EstadoCuentaEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.CostoHospitalizacionDTO;
import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.DetalleMedicamentoEstudioDTO;
import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.EstadoCuentaDTO;
import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.PagoDTO;
import com.saludsystem.submodules.paciente.model.entity.Paciente;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.CostoHospitalizacion;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.DetalleMedicamentoEstudio;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.EstadoCuenta;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.Pago;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class EstadoCuentaMapper {

    public EstadoCuenta fromCreateDto(EstadoCuentaCreateCommand createCommand) {
        return new EstadoCuenta(
                null, // ID generado por persistencia
                createCommand.getPacienteId(),
                createCommand.getFechaApertura(),
                createCommand.getEstado(),
                createCommand.getTotalHospitalizacion(),
                createCommand.getTotalMedicamentosEstudios(),
                createCommand.getTotalPagado(),
                createCommand.getSaldoPendiente(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList()
        );
    }

    public EstadoCuenta fromUpdateDto(UUID uuid, EstadoCuentaEditCommand editCommand) {
        return new EstadoCuenta(
                uuid,
                editCommand.getPacienteId(),
                editCommand.getFechaApertura(),
                editCommand.getEstado(),
                editCommand.getTotalHospitalizacion(),
                editCommand.getTotalMedicamentosEstudios(),
                editCommand.getTotalPagado(),
                editCommand.getSaldoPendiente(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList()
        );
    }

    public EstadoCuentaDTO toDto(EstadoCuenta model) {
        return new EstadoCuentaDTO(
                model.getEstadoCuentaId(),
                model.getPacienteId(),
                model.getFechaApertura(),
                model.getEstado(),
                model.getTotalHospitalizacion(),
                model.getTotalMedicamentosEstudios(),
                model.getTotalPagado(),
                model.getSaldoPendiente(),
                mapCostosHospitalizacion(model.getCostosHospitalizacion()),
                mapDetallesMedicamentosEstudios(model.getDetallesMedicamentosEstudios()),
                mapPagos(model.getPagos())
        );
    }

    private List<CostoHospitalizacionDTO> mapCostosHospitalizacion(List<CostoHospitalizacion> list) {
        if (list == null) return Collections.emptyList();
        return list.stream()
                .map(c -> new CostoHospitalizacionDTO(
                        c.getPec_costoHospitalizacionId(),
                        c.getEstadoCuentaId(),
                        c.getPacienteId(),
                        c.getFechaIngreso(),
                        c.getFechaAlta(),
                        c.getTipoHabitacion(),
                        c.getCostoPorDia(),
                        c.getCantidadDias(),
                        c.getTotalCosto()
                ))
                .toList();
    }

    private List<DetalleMedicamentoEstudioDTO> mapDetallesMedicamentosEstudios(List<DetalleMedicamentoEstudio> list) {
        if (list == null) return Collections.emptyList();
        return list.stream()
                .map(d -> new DetalleMedicamentoEstudioDTO(
                        d.getPec_detalleMedicamentoId(),
                        d.getPacienteId(),
                        d.getEstadoCuentaId(),
                        d.getTipo(),
                        d.getDescripcion(),
                        d.getCantidad(),
                        d.getCostoUnitario(),
                        d.getTotalCosto()
                ))
                .toList();
    }

    private List<PagoDTO> mapPagos(List<Pago> list) {
        if (list == null) return Collections.emptyList();
        return list.stream()
                .map(p -> new PagoDTO(
                        p.getPecPagoId(),
                        p.getPacEstadoCuentaId(),
                        p.getFechaPago(),
                        p.getMonto(),
                        p.getMetodoPago(),
                        p.getReferenciaPago()
                ))
                .toList();
    }

}
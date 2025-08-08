package com.saludsystem.submodules.paciente.model.entity.estadocuenta;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class EstadoCuenta {

    private UUID estadoCuentaId;
    private UUID pacienteId;
    private Date fechaApertura;
    private String estado; // Ej: ABIERTA, CERRADA, PAGADA
    private Double totalHospitalizacion;
    private Double totalMedicamentosEstudios;
    private Double totalPagado;
    private Double saldoPendiente;

    private List<CostoHospitalizacion> costosHospitalizacion;
    private List<DetalleMedicamentoEstudio> detallesMedicamentosEstudios;
    private List<Pago> pagos;

}

package com.saludsystem.submodules.paciente.model.entity.estadocuenta;

import com.saludsystem.submodules.paciente.model.entity.Paciente;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class EstadoCuenta {

    private UUID estadoCuentaId;
    private Paciente paciente;
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

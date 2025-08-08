package com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EstadoCuentaDTO {

    private UUID pacEstadoCuentaId;

    private UUID pacienteId;

    private Date fechaApertura;

    private String estado;

    @Schema(example = "0")
    private Double totalHospitalizacion;

    @Schema(example = "0")
    private Double totalMedicamentosEstudios;

    @Schema(example = "0")
    private Double totalPagado;

    @Schema(example = "0")
    private Double saldoPendiente;

    private List<CostoHospitalizacionDTO> costosHospitalizacion;
    private List<DetalleMedicamentoEstudioDTO> detallesMedicamentosEstudios;
    private List<EPagoDTO> pagos;

}
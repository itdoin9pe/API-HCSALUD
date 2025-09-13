package com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EstadoCuentaDTO
{
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
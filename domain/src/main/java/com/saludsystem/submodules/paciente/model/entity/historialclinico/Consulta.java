package com.saludsystem.submodules.paciente.model.entity.historialclinico;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class Consulta {
	private UUID pacienteConsultaId;
	private UUID pacienteId;
	private UUID especialidadId;
	private String motivoConsulta;
	private String diagnosticoPresuntivo;
	private boolean tieneAlergia;
	private String tieneAlergiaTexto;
	private boolean tomaMedicamento;
	private String tomaMedicamentoTexto;
	private boolean cirugiasPrevias;
	private String cirugiasPreviasTexto;
	private String enfermedadesCronicas;
	private boolean transfusionesSanguineas;
	private boolean historialPsiquiatrico;
	private boolean fuma;
	private boolean consumeAlcohol;
	private String actividadFisica;
	private boolean embarazada;
	private LocalDate ultimaMenstruacion;

	public Consulta(UUID pacienteConsultaId, UUID pacienteId, UUID especialidadId, String motivoConsulta,
			String diagnosticoPresuntivo, boolean tieneAlergia, String tieneAlergiaTexto, boolean tomaMedicamento,
			String tomaMedicamentoTexto, boolean cirugiasPrevias, String cirugiasPreviasTexto,
			String enfermedadesCronicas, boolean transfusionesSanguineas, boolean historialPsiquiatrico, boolean fuma,
			boolean consumeAlcohol, String actividadFisica, boolean embarazada, LocalDate ultimaMenstruacion) {
		this.pacienteConsultaId = pacienteConsultaId;
		this.pacienteId = pacienteId;
		this.especialidadId = especialidadId;
		this.motivoConsulta = motivoConsulta;
		this.diagnosticoPresuntivo = diagnosticoPresuntivo;
		this.tieneAlergia = tieneAlergia;
		this.tieneAlergiaTexto = tieneAlergiaTexto;
		this.tomaMedicamento = tomaMedicamento;
		this.tomaMedicamentoTexto = tomaMedicamentoTexto;
		this.cirugiasPrevias = cirugiasPrevias;
		this.cirugiasPreviasTexto = cirugiasPreviasTexto;
		this.enfermedadesCronicas = enfermedadesCronicas;
		this.transfusionesSanguineas = transfusionesSanguineas;
		this.historialPsiquiatrico = historialPsiquiatrico;
		this.fuma = fuma;
		this.consumeAlcohol = consumeAlcohol;
		this.actividadFisica = actividadFisica;
		this.embarazada = embarazada;
		this.ultimaMenstruacion = ultimaMenstruacion;
	}
}
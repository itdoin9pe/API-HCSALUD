package com.saludsystem.submodules.paciente.dtos.put.historialclinico;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarConsultaDTO extends BaseDTO {

    protected UUID pacienteConsultaId;
    protected UUID pacienteId;
    protected UUID especialidadId;
    protected String motivoConsulta;
    protected String diagnosticoPresuntivo;

    @Schema(description = "Valor boolean (true / false)", example = "s")
    protected boolean tieneAlergia;
    protected String tieneAlergiaTexto;

    @Schema(description = "Valor boolean (true / false)", example = "s")
    protected boolean tomaMedicamento;
    protected String tomaMedicamentoTexto;

    @Schema(description = "Valor boolean (true / false)", example = "s")
    protected boolean cirugiasPrevias;
    protected String cirugiasPreviasTexto;

    protected String enfermedadesCronicas;

    @Schema(description = "Valor boolean (true / false)", example = "s")
    protected boolean transfusionesSanguineas;

    @Schema(description = "Valor boolean (true / false)", example = "s")
    protected boolean historialPsiquiatrico;

    @Schema(description = "Valor boolean (true / false)", example = "s")
    protected boolean fuma;

    @Schema(description = "Valor boolean (true / false)", example = "s")
    protected boolean consumeAlcohol;

    protected String actividadFisica;

    @Schema(description = "Valor boolean (true / false)", example = "s")
    protected boolean embarazada;

    protected LocalDate ultimaMenstruacion;
}
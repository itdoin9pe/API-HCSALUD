package com.saludSystem.application.dtos.Paciente.POST.HistorialClinico;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class CrearConsultaDTO {
    private UUID pacienteConsultaId;
    private UUID pacienteId;
    private UUID especialidadId;
    private String motivoConsulta;
    private String diagnosticoPresuntivo;

    @Schema(description = "Valor boolean (true / false)", example = "s")
    private boolean tieneAlergia;
    private String tieneAlergiaTexto;
    @Schema(description = "Valor boolean (true / false)", example = "s")
    private boolean tomaMedicamento;
    private String tomaMedicamentoTexto;
    @Schema(description = "Valor boolean (true / false)", example = "s")
    private boolean cirugiasPrevias;
    private String cirugiasPreviasTexto;
    private String enfermedadesCronicas;
    @Schema(description = "Valor boolean (true / false)", example = "s")
    private boolean transfusionesSanguineas;
    @Schema(description = "Valor boolean (true / false)", example = "s")
    private boolean historialPsiquiatrico;
    @Schema(description = "Valor boolean (true / false)", example = "s")
    private boolean fuma;
    @Schema(description = "Valor boolean (true / false)", example = "s")
    private boolean consumeAlcohol;
    private String actividadFisica;
    @Schema(description = "Valor boolean (true / false)", example = "s")
    private boolean embarazada;
    private LocalDate ultimaMenstruacion;
}
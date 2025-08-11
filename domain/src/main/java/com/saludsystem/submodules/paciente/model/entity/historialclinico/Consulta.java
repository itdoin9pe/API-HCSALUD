package com.saludsystem.submodules.paciente.model.entity.historialclinico;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Consulta {

    private UUID pacienteConsultaId;
    private UUID pacienteEntity;
    private UUID especialidadEntity;
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

}

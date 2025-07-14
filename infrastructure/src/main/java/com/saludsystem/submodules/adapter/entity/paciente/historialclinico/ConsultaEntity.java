package com.saludsystem.submodules.adapter.entity.paciente.historialclinico;

import com.saludsystem.submodules.adapter.entity.catalogo.EspecialidadEntity;
import com.saludsystem.submodules.adapter.entity.configuracion.BaseEntity;
import com.saludsystem.submodules.adapter.entity.paciente.PacienteEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "pacientes_consultas")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class ConsultaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "paciente_consulta_id", nullable = false)
    private UUID pacienteConsultaId;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private PacienteEntity pacienteEntity;

    @ManyToOne
    @JoinColumn(name = "id_especialidad", nullable = false)
    private EspecialidadEntity especialidadEntity;

    @Column(columnDefinition = "TEXT", name = "motivoConsulta_paciente", nullable = false)
    private String motivoConsulta;

    @Column(columnDefinition = "TEXT", name = "paciente_diagnostico_presuntivo", nullable = true)
    private String diagnosticoPresuntivo;

    @Column(name = "paciente_alergia", nullable = false)
    private boolean tieneAlergia;

    @Column(columnDefinition = "TEXT", name = "paciente_alergia_txt", nullable = true)
    private String tieneAlergiaTexto;

    @Column(name = "paciente_toma_medicamente", nullable = false)
    private boolean tomaMedicamento;

    @Column(columnDefinition = "TEXT", name = "paciente_toma_medicamento_txt", nullable = true)
    private String tomaMedicamentoTexto;

    @Column(name = "paciente_cirugiasPrevias", nullable = false)
    private boolean cirugiasPrevias;

    @Column(columnDefinition = "TEXT", name = "paciente_cirugiasPrevias_txt", nullable = true)
    private String cirugiasPreviasTexto;

    @Column(name = "paciente_enfermedades_cronicas", nullable = false)
    private String enfermedadesCronicas;

    @Column(name = "paciente_transfusion_sanguinea", nullable = false)
    private boolean transfusionesSanguineas;

    @Column(name = "paciente_historial_psquiatrico", nullable = false)
    private boolean historialPsiquiatrico;

    @Column(name = "paciente_fuma", nullable = false)
    private boolean fuma;

    @Column(name = "paciente_comsumeAlcohol", nullable = false)
    private boolean consumeAlcohol;

    @Column(columnDefinition = "TEXT", length = 100, name = "paciente_actividadFisica_txt", nullable = false)
    private String actividadFisica;

    @Column(name = "embarazo_paciente", nullable = true)
    private boolean embarazada;

    @Column(name = "ultima_menstruacion_paciente", nullable = true)
    private LocalDate ultimaMenstruacion;

}
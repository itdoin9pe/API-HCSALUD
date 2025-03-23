package com.saludSystem.Mantenimiento.Diagnostico.dominio;

import com.saludSystem.Generals.adapter.BaseEntity;
import com.saludSystem.Paciente.dominio.PacienteModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "diagnosticos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DiagnosticoModel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "pacienteDiagnostico_id", nullable = false)
    private UUID pacienteDiagnosticoId;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private PacienteModel pacienteId;

    @Column(name = "enfermedadId", nullable = false, unique = true)
    private String enfermedadId;

    @Column(name = "descripcion_diagnostico", nullable = false)
    private String nombreEnfermedad;

    @Column(name = "fecha_diagnosticos", nullable = false)
    private LocalDate fecha;

    @Column(name = "estado_descripcion", nullable = false)
    private Integer estado;

}

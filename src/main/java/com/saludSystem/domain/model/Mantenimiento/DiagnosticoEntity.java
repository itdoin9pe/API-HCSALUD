package com.saludSystem.domain.model.Mantenimiento;

import com.saludSystem.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "diagnosticos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DiagnosticoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "pacienteDiagnostico_id", nullable = false)
    private UUID pacienteDiagnosticoId;

    /*
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteModel pacienteId;
     */

    @Column(name = "enfermedadId", nullable = false, unique = true)
    private String enfermedadId;

    @Column(name = "descripcion_diagnostico", nullable = false)
    private String nombreEnfermedad;

    @Column(name = "estado_descripcion", nullable = false)
    private Integer estado;

}
package com.saludSystem.domain.model.Paciente.Tratamiento;

import com.saludSystem.domain.model.BaseEntity;
import com.saludSystem.domain.model.Catalogo.MedidaEntity;
import com.saludSystem.domain.model.Medico.DoctorEntity;
import com.saludSystem.domain.model.Paciente.PacienteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "pacientes_procedimientos")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ProcedimientoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_procedimiento_tratamiento")
    private UUID procedimientoId;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private PacienteEntity pacienteEntity;

    @ManyToOne
    @JoinColumn(name = "id_doctor")
    private DoctorEntity doctorEntity;

    @Column(name = "tipo_prodedimiento", nullable = false)
    private TipoProcedimiento tipoProcedimiento;

    @Column(name = "descripcion_procedimiento", nullable = false)
    private String descripcion;

    @Column(name = "fecha_procedimiento", nullable = false)
    private LocalDate fecha;

    @Column(name = "resultado_procedimiento", nullable = false)
    private String resultado;

}
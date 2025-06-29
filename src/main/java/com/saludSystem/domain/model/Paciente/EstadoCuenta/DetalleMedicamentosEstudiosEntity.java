package com.saludSystem.domain.model.Paciente.EstadoCuenta;

import com.saludSystem.domain.model.BaseEntity;
import com.saludSystem.domain.model.Paciente.PacienteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "pacientes_detalles_medicamentos_estudios")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class DetalleMedicamentosEstudiosEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_detalle", nullable = false)
    private UUID pec_detalleMedicamentoId;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private PacienteEntity pacienteEntity;

    @ManyToOne
    @JoinColumn(name = "id_estado_cuenta", nullable = false)
    private EstadoCuentaEntity estadoCuentaEntity;

    @Column(name = "tipo", nullable = false)
    private String tipo; // "MEDICAMENTO" o "ESTUDIO"

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "costo_unitario", nullable = false)
    private Double costoUnitario;

    @Column(name = "total_costo", nullable = false)
    private Double totalCosto;

}
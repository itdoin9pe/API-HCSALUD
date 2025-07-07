package com.saludsystem.paciente.domain.model.EstadoCuenta;

import com.saludsystem.shared.domain.model.BaseEntity;
import com.saludsystem.paciente.domain.model.PacienteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "pacientes_costo_hospitalizacion")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CostoHospitalizacionEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_costo_hospitalizacion", nullable = false)
    private UUID pec_costoHospitalizacionId;

    @ManyToOne
    @JoinColumn(name = "id_estado_cuenta", nullable = false)
    private EstadoCuentaEntity estadoCuentaEntity;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private PacienteEntity pacienteEntity;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_alta", nullable = false)
    private LocalDate fechaAlta;

    @Column(name = "tipo_habitacion", nullable = false)
    private String tipoHabitacion;

    @Column(name = "costo_por_dia", nullable = false)
    private Double costoPorDia;

    @Column(name = "cantidad_dias", nullable = false)
    private Integer cantidadDias;

    @Column(name = "total_costo", nullable = false)
    private Double totalCosto;

}
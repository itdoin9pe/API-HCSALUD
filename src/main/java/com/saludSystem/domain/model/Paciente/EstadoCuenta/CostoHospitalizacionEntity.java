package com.saludSystem.domain.model.Paciente.EstadoCuenta;

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
public class CostoHospitalizacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_costo_hospitalizacion", nullable = false)
    private UUID pec_costoHospitalizacionId;

    @ManyToOne
    @JoinColumn(name = "id_estado_cuenta", nullable = false)
    private EstadoCuentaEntity estadoCuentaEntity;

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
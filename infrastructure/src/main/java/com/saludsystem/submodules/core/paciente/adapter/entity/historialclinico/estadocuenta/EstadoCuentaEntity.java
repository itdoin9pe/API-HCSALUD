package com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.estadocuenta;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pacientes_estados_cuentas")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class EstadoCuentaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_estado_cuenta", nullable = false)
    private UUID pec_estadoCuentaId;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private PacienteEntity pacienteEntity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_apertura", nullable = false)
    private Date fechaApertura;

    @Column(name = "estado", nullable = false)
    private String estado; // Exp: ABIERTA, CERRADA, PAGADA

    @Column(name = "total_hospitalizacion")
    private Double totalHospitalizacion;

    @Column(name = "total_medicamentos_estudios")
    private Double totalMedicamentosEstudios;

    @Column(name = "total_pagado")
    private Double totalPagado;

    @Column(name = "saldo_pendiente")
    private Double saldoPendiente;

    // Relaciones
    @OneToMany(mappedBy = "estadoCuentaEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CostoHospitalizacionEntity> costosHospitalizacion;

    @OneToMany(mappedBy = "estadoCuentaEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleMedicamentosEstudiosEntity> detallesMedicamentosEstudios;

    @OneToMany(mappedBy = "estadoCuentaEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EPagoEntity> pagos;

}
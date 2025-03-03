package com.saludSystem.domain.entities.Catalogo;

import com.saludSystem.domain.entities.Configuracion.User;
import com.saludSystem.domain.entities.Configuracion.SysSalud;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "planes")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_plan", nullable = false, unique = true)
    private UUID planId;

    @Column(name = "nombre_plan", nullable = false, length = 100)
    private String nombrePlan;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin_contrato", nullable = false)
    private LocalDateTime fechaFinContrato;

    @Column(name = "max_plan", nullable = false)
    private int maxPlan;

    @Column(name = "usu_max", nullable = false)
    private int usuMax;

    @Column(name = "costo_plan", nullable = false)
    private Double costoPlan;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private SysSalud hospital;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private User user;

}
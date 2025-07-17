package com.saludsystem.submodules.sections.paciente.adapter.entity;

import com.saludsystem.submodules.sections.catalogo.adapter.entity.MedicamentoEntity;
import com.saludsystem.submodules.sections.configuracion.adapter.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "pacientes_medicamentos_recetados")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class MedicamentoRecetadoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receta_id", nullable = false)
    private RecetaEntity recetaEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicamento_id", nullable = false)
    private MedicamentoEntity medicamentoEntity;

    @Column(nullable = false)
    private String dosis; // ej: "500 mg/400 mg"

    @Column(nullable = false)
    private String frecuencia; // ej: "3 o 2 veces al día"

    @Column(nullable = true)
    private Integer duracionDias; // duración en días / 24 horas

    @Column(length = 500)
    private String indicaciones; // indicaciones adicionales - Opcional

}
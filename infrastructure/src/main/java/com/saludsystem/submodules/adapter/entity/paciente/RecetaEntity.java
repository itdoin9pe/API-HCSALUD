package com.saludsystem.submodules.adapter.entity.paciente;

import com.saludsystem.submodules.adapter.entity.configuracion.BaseEntity;
import com.saludsystem.submodules.adapter.entity.medico.DoctorEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pacientes_recetas")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class RecetaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "paciente_receta_id", nullable = false)
    private UUID pacienteRecetaId;

    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private DoctorEntity doctorEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente", nullable = false)
    private PacienteEntity pacienteEntity;

    @Column(length = 500)
    private String observaciones;

    @Column(name = "estado_receta")
    private Integer estado;

    @OneToMany(mappedBy = "recetaEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicamentoRecetadoEntity> medicamentosRecetados;

}
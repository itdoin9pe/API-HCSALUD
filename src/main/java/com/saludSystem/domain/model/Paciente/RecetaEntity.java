package com.saludSystem.domain.model.Paciente;

import com.saludSystem.domain.model.BaseEntity;
import com.saludSystem.domain.model.Medico.DoctorEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pacientes_recetas")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
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
package com.saludSystem.domain.model.Paciente.Evolucion;

import com.saludSystem.domain.model.BaseEntity;
import com.saludSystem.domain.model.Paciente.PacienteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pacientes_evoluciones")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class EvolucionEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "paciente_evolucion_id", nullable = false)
    private UUID pacienteEvolucionId;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private PacienteEntity pacienteEntity;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    private Boolean finalizada = false;

    @OneToMany(mappedBy = "evolucionEntity", cascade = CascadeType.ALL)
    private List<NotaEntity> notas;

    @OneToMany(mappedBy = "evolucionEntity", cascade = CascadeType.ALL)
    private List<CambioCondicionEntity> cambios;

    @OneToOne(mappedBy = "evolucionEntity", cascade = CascadeType.ALL)
    private AltaMedicaEntity altaMedica;

}
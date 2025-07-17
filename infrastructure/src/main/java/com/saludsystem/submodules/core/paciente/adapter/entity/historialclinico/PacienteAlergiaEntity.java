package com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico;

import com.saludsystem.submodules.core.catalogo.adapter.entity.AlergiaEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "pacientes_alergias")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class PacienteAlergiaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "paciente_alergia_id", nullable = false)
    private UUID pacienteAlergiaId;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private PacienteEntity pacienteEntity;

    @ManyToOne
    @JoinColumn(name = "alergia_id", nullable = false)
    private AlergiaEntity alergiaEntity;

    @Column(name = "paciente_alergia_observacion", nullable = false)
    private String observacion;

    @Column(name = "paciente_alergia_estado", nullable = false)
    private Integer estado;

}
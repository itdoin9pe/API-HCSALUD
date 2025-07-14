package com.saludsystem.submodules.adapter.entity.paciente.historialclinico;

import com.saludsystem.submodules.adapter.entity.catalogo.AlergiaEntity;
import com.saludsystem.submodules.adapter.entity.configuracion.BaseEntity;
import com.saludsystem.submodules.adapter.entity.paciente.PacienteEntity;
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
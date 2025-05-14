package com.saludSystem.domain.model.Paciente.HistorialClinico;

import com.saludSystem.domain.model.BaseEntity;
import com.saludSystem.domain.model.Catalogo.AlergiaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "pacientes_alergias")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class PacienteAlergiaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "paciente_alergia_id", nullable = false)
    private UUID pacienteAlergiaId;

    @ManyToOne
    @JoinColumn(name = "alergia_id", nullable = false)
    private AlergiaEntity alergiaEntity;

    @Column(name = "paciente_alergia_observacion", nullable = false)
    private String observacion;

    @Column(name = "paciente_alergia_estado", nullable = false)
    private Integer estado;

}
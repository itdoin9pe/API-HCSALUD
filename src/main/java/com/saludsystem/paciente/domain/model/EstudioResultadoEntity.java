package com.saludsystem.paciente.domain.model;

import com.saludsystem.shared.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pacientes_estudios_resultados")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class EstudioResultadoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente_estudio_resultado", nullable = false)
    private Long Id;

    @Column(name = "estudio_resultado_reporte", nullable = false)
    private String reporteTexto;

    @Column(name = "estudio_resultado_imagen", nullable = false)
    private String urlImg;

    @OneToOne
    @JoinColumn(name = "id_paciente_estudio")
    private EstudioMedicoEntity estudioMedicoEntity;

    private LocalDateTime createdAt;

}
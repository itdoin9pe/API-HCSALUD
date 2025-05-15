package com.saludSystem.domain.model.Paciente;

import com.saludSystem.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "pacientes_estudios_resultados")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
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
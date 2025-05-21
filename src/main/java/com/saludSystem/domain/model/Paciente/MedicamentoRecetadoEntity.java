package com.saludSystem.domain.model.Paciente;

import com.saludSystem.domain.model.BaseEntity;
import com.saludSystem.domain.model.Catalogo.MedicamentoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "pacientes_medicamentos_recetados")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
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
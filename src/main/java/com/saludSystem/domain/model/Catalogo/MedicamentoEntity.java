package com.saludSystem.domain.model.Catalogo;

import com.saludSystem.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "medicamentos")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class MedicamentoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "medicamento_id", nullable = false)
    private UUID medicamentoId;

    @Column(name = "medicamento_nombre", nullable = false, unique = true)
    private String nombre;

    @Column(name = "forma_medicamento")
    private String formaFarmaceutica; // Ej: "Tableta", "Jarabe"

    @Column(name = "concentracion_medicamento")
    private String concentracion;     // Ej: "500 mg"

    @Column(name = "contenido_medicamento")
    private String contenido;         // Ej: "Caja con 10 tabletas"

    @Column(name = "estado_medicamento")
    private Integer estado;

}
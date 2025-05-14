package com.saludSystem.domain.model.Operaciones;

import com.saludSystem.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "unidades")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class UnidadEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "unidad_id", nullable = false)
    private UUID unidadId;

    @Column(name = "nombre_unidad", nullable = false)
    private String nombre;

    @Column(name = "siglas_unidad", nullable = false)
    private String siglas;

    @Column(name = "descripcion_unidad", nullable = false)
    private String descripcion;

    @Column(name = "estado_unidad", nullable = false)
    private Integer estado;

}
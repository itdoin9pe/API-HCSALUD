package com.saludSystem.domain.model.Operaciones;

import com.saludSystem.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tipos_materiales")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class TipoMaterialEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tipoMaterial_id", nullable = false)
    private UUID tipoMaterialId;

    @Column(name = "nombre_tipoMaterial", nullable = false)
    private String nombre;

    @Column(name = "descripcion_tipoMaterial", nullable = false)
    private String descripcion;

    @Column(name = "estado_tipoMaterial", nullable = false)
    private Integer estado;

}
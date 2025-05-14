package com.saludSystem.domain.model.Operaciones;

import com.saludSystem.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "marcas_materiales")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MarcaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "marcaMateriales_id", nullable = false)
    private UUID marcaMaterialesId;

    @Column(name = "nombre_marca", nullable = false)
    private String nombre;

    @Column(name = "estado_marca", nullable = false)
    private Integer estado;

}
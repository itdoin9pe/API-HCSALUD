package com.saludSystem.Operaciones.Marca.dominio;

import com.saludSystem.Generals.adapter.BaseEntity;
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
public class MarcaModel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "marcaMateriales_id", nullable = false)
    private UUID marcaMaterialesId;

    @Column(name = "nombre_marca", nullable = false)
    private String nombre;

    @Column(name = "estado_marca", nullable = false)
    private Integer estado;

}
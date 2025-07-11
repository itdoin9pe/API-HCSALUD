package com.saludsystem.infrastructure.adapter.entity.catalogo;

import com.saludsystem.infrastructure.adapter.entity.configuracion.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categorias")
public class CategoriaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_categoria", nullable = false)
    private UUID categoriaId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotNull
    @Column(name = "estado", nullable = false)
    private Integer estado;

}
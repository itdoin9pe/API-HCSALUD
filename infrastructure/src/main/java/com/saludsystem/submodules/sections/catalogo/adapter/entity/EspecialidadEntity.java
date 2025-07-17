package com.saludsystem.submodules.sections.catalogo.adapter.entity;

import com.saludsystem.submodules.sections.configuracion.adapter.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "especialidades")
public class EspecialidadEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_especialidad", nullable = false)
    private UUID especialidadId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotNull
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @NotNull
    @Column(name = "estado", nullable = false)
    private Integer estado;

}
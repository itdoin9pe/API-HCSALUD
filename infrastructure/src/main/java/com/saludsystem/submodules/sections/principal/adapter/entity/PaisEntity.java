package com.saludsystem.submodules.sections.principal.adapter.entity;

import com.saludsystem.submodules.sections.configuracion.adapter.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "paises")
@EqualsAndHashCode(callSuper = true)
public class PaisEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pais", nullable = false, unique = true)
    private Integer id;

    @NotBlank(message = "this field cant be empty")
    @Column(name = "iso", nullable = false)
    private String iso;

    @NotBlank(message = "this field cant be empty")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotBlank(message = "this field cant be empty")
    @Column(name = "gentilicio")
    private String gentilicio;

    @Column(name = "orden")
    private Integer orden;

}
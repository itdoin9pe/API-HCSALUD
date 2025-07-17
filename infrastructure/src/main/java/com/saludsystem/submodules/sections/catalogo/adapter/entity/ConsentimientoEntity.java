package com.saludsystem.submodules.sections.catalogo.adapter.entity;

import com.saludsystem.submodules.sections.configuracion.adapter.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "consentimientos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConsentimientoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "consentimiento_id", nullable = false)
    private UUID consentimientoId;

    @Column(name = "nombre_consentimiento", nullable = false)
    private String nombre;

    @Column(name = "observacion_consentimiento", nullable = false)
    private String observacion;

    @Column(name = "estado_consentimiento", nullable = false)
    private Integer estado;

    @Column(name = "texto_consentimiento", nullable = false)
    private String texto;

}
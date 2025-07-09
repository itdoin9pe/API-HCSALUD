package com.saludsystem.catalogo.domain.model;

import com.saludsystem.shared.domain.model.BaseEntity;
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
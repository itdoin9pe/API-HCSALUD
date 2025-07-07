package com.saludsystem.catalogo.domain.model;

import com.saludsystem.shared.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "apoderados")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApoderadoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "apoderado_id", nullable = false)
    private UUID apoderadoId;

    @Column(name = "nombre_apoderado", nullable = false)
    private String nombre;

    @Column(name = "nroDocumento_apoderado", nullable = false, unique = true)
    private String nroDocumento;

    @Column(name = "direccion_apoderado", nullable = false)
    private String direccion;

    @Column(name = "telefono_apoderado", unique = true)
    private String telefono;

    @Column(name = "estado_apoderado", nullable = false)
    private Integer estado;

}
package com.saludsystem.domain.model.catalogo;

import com.saludsystem.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tipo_concepto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TipoConceptoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tipo_conceptoId", nullable = false)
    private UUID tipoConceptoId;

    @Column(name = "nombre_tipoConcepto", nullable = false)
    private String nombre;

    @Column(name = "estado_tipoConcepto", nullable = false)
    private Integer estado;

}
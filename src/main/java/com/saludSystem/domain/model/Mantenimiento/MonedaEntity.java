package com.saludSystem.domain.model.Mantenimiento;

import com.saludSystem.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "monedas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MonedaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID monedaId;

    @Column(name = "descripcion_moneda", nullable = false)
    private String descripcion;

    @Column(name = "estado_moneda", nullable = false)
    private Integer estado;

}
package com.saludSystem.Mantenimiento.TipoGasto.dominio;

import com.saludSystem.Generals.adapter.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tipos_gasto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TipoGastoModel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "conceptoGastoId", nullable = false)
    private UUID conceptoGastoId;

    @Column(name = "descripcion_gasto", nullable = false, unique = true)
    private String nombre;

    @Column(name = "estado_gastos", nullable = false)
    private Integer estado;

}
package com.saludSystem.Mantenimiento.TipoPago.dominio;

import com.saludSystem.Generals.adapter.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tipos_pago")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TipoPagoModel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_tipoPagos", nullable = false)
    private UUID tipoPagoId;

    @Column(name = "metodoPago", nullable = false)
    private String metodoPago;

    @Column(name = "descripcion_tipoPago", nullable = false)
    private String descripcion;

    @Column(name = "estado_tipoPago", nullable = false)
    private Integer estado;

}

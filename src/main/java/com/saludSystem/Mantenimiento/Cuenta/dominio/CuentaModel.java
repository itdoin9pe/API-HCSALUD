package com.saludSystem.Mantenimiento.Cuenta.dominio;

import com.saludSystem.Generals.adapter.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "cuentas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CuentaModel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cuentasPagar_id", nullable = false)
    private UUID cuentaPagarId;

    @Column(name = "nombre_cuenta", nullable = false, unique = true)
    private String nombre;

    @Column(name = "total_cuenta", nullable = false)
    private Integer total;

    @Column(name = "estado_cuenta", nullable = false)
    private Integer estado;

}

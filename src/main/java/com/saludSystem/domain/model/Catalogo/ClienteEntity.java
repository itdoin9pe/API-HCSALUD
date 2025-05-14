package com.saludSystem.domain.model.Catalogo;

import com.saludSystem.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "clientes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cliente_id", nullable = false)
    private UUID clienteId;

    @Column(name = "tipoDocumento_cliente", nullable = false)
    private String tipoDocumento;

    @Column(name = "nombre_cliente", nullable = false)
    private String nombre;

    @Column(name = "direccion_cliente", nullable = false)
    private String direccion;

    @Column(name = "contacto_cliente", nullable = false)
    private String contacto;

    @Column(name = "telefono_cliente", nullable = false)
    private String telefono;

    @Column(name = "email_cliente", nullable = false, unique = true)
    private String email;

    @Column(name = "estado_cliente", nullable = false)
    private Integer estado;

}
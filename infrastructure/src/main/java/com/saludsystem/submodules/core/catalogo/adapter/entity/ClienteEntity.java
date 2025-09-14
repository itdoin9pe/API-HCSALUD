package com.saludsystem.submodules.core.catalogo.adapter.entity;

import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "clientes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteEntity extends BaseEntity
{
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
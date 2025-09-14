package com.saludsystem.submodules.core.principal.adapter.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SedeEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.movimiento.adapter.entity.AlmacenEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sucursales")
public class SucursalEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "sucursal_id", nullable = false, unique = true)
	private UUID sucursalId;

	private String nombre;
	private String direccion;
	private boolean isDefault;

	@ManyToOne
	@JoinColumn(name = "hospital_id", nullable = false)
	private SysSaludEntity hospital;

	@OneToMany(mappedBy = "sucursalEntity", cascade = CascadeType.ALL)
	private List<AlmacenEntity> almacenes = new ArrayList<>();

	@OneToMany(mappedBy = "sucursalEntity", cascade = CascadeType.ALL)
	private List<SedeEntity> sedes;
}

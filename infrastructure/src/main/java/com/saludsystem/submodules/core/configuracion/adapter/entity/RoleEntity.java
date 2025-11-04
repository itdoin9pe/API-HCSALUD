package com.saludsystem.submodules.core.configuracion.adapter.entity;

import java.util.List;
import java.util.UUID;

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
import lombok.ToString;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude =
{ "usuarios", "permisos", "hospital" }) // 🔥 importante
public class RoleEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "rol_id", nullable = false, unique = true)
	private UUID roleId;

	@Column(name = "estado", nullable = false)
	private Integer estado;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "hospital_id", referencedColumnName = "hospital_id", nullable = false)
	private SysSaludEntity hospital;

	@OneToMany(mappedBy = "rol")
	private List<UserEntity> usuarios;

	@OneToMany(mappedBy = "rol")
	private List<PermisoEntity> permisos;
}
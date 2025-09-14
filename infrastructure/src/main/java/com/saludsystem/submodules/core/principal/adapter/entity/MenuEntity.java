package com.saludsystem.submodules.core.principal.adapter.entity;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.core.configuracion.adapter.entity.PermisoEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;

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
@Table(name = "menus")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "menu_id", nullable = false, unique = true)
	private UUID menuId;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "ruta", nullable = false)
	private String ruta;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity user;

	@ManyToOne
	@JoinColumn(name = "hospital_id", nullable = false)
	private SysSaludEntity hospital;

	@OneToMany(mappedBy = "menuEntity")
	private List<PermisoEntity> permisoEntities;
}

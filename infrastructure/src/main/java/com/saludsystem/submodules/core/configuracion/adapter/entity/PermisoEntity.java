package com.saludsystem.submodules.core.configuracion.adapter.entity;

import java.util.UUID;

import com.saludsystem.submodules.core.principal.adapter.entity.MenuEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "permisos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PermisoEntity extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID permisoId;

	@Column(name = "`delete`")
	private Boolean delete;

	@Column(name = "`insert`")
	private Boolean insert;

	@Column(name = "`read`")
	private Boolean read;

	@Column(name = "`update`")
	private Boolean update;

	@ManyToOne
	@JoinColumn(name = "rol_id", nullable = false)
	private RoleEntity rol;

	@ManyToOne
	@JoinColumn(name = "menu_id", nullable = false)
	private MenuEntity menuEntity;
}
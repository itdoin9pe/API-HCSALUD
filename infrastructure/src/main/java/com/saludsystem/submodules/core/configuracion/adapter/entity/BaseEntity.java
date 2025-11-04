package com.saludsystem.submodules.core.configuracion.adapter.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class BaseEntity
{
	@ManyToOne
	@JoinColumn(name = "hospital_id", referencedColumnName = "hospital_id", nullable = false)
	private SysSaludEntity hospital;

	@ManyToOne
	@JoinColumn(name = "id_user", nullable = false)
	private UserEntity user;
}
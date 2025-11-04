package com.saludsystem.submodules.core.mantenimiento.adapter.mapper;

import java.util.UUID;

import com.saludsystem.submodules.core.catalogo.adapter.entity.CategoriaEntity;
import com.saludsystem.submodules.core.catalogo.adapter.entity.MedidaEntity;
import com.saludsystem.submodules.core.catalogo.adapter.entity.TipoConceptoEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.TarifarioEntity;
import com.saludsystem.submodules.core.operaciones.adapter.entity.UnidadEntity;
import com.saludsystem.submodules.mantenimiento.model.Tarifario;

public class TarifarioDboMapper
{
	public static TarifarioEntity toEntity(Tarifario model, UUID userId, UUID hospitalId)
	{
		TarifarioEntity entity = new TarifarioEntity();
		entity.setTarifarioId(model.getId());

		TipoConceptoEntity tipoConcepto = new TipoConceptoEntity();
		tipoConcepto.setTipoConceptoId(model.getTipoConceptoId());
		entity.setTipoConceptoEntity(tipoConcepto);

		MedidaEntity medida = new MedidaEntity();
		medida.setMedidaId(model.getMedidaId());
		entity.setMedidaEntity(medida);

		CategoriaEntity categoria = new CategoriaEntity();
		categoria.setCategoriaId(model.getCategoriaId());
		entity.setCategoriaEntity(categoria);

		UnidadEntity unidad = new UnidadEntity();
		unidad.setUnidadId(model.getUnidadId());
		entity.setUnidadEntity(unidad);

		entity.setGrupo(model.getGrupo());
		entity.setDescripcion(model.getDescripcion());
		entity.setPrecio(model.getPrecio());
		entity.setEstado(model.getEstado());

		var userEntity = new UserEntity();
		userEntity.setUserId(userId);
		entity.setUser(userEntity);

		var hospitalEntity = new SysSaludEntity();
		hospitalEntity.setHospitalId(hospitalId);
		entity.setHospital(hospitalEntity);

		return entity;
	}

	public static Tarifario toDomain(TarifarioEntity entity)
	{
		return new Tarifario(entity.getTarifarioId(), entity.getTipoConceptoEntity().getTipoConceptoId(),
				entity.getMedidaEntity().getMedidaId(), entity.getCategoriaEntity().getCategoriaId(),
				entity.getUnidadEntity().getUnidadId(), entity.getGrupo(), entity.getDescripcion(), entity.getPrecio(),
				entity.getEstado());
	}
}

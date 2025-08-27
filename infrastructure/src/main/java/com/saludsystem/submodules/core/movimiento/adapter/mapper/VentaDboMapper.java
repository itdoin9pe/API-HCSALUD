package com.saludsystem.submodules.core.movimiento.adapter.mapper;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.TipoDocumentoEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.MonedaEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.TipoPagoEntity;
import com.saludsystem.submodules.core.mantenimiento.adapter.entity.TipoTarjetaEntity;
import com.saludsystem.submodules.core.movimiento.adapter.entity.AlmacenEntity;
import com.saludsystem.submodules.core.movimiento.adapter.entity.VentaDetalleEntity;
import com.saludsystem.submodules.core.movimiento.adapter.entity.VentaEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import com.saludsystem.submodules.movimiento.model.Venta;
import com.saludsystem.submodules.movimiento.model.VentaDetalle;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class VentaDboMapper {

    public static VentaEntity toEntity(Venta model, UUID hospitalId, UUID userId) {

        VentaEntity entity = new VentaEntity();
        entity.setVentaId(model.getVentaId());
        entity.setSerie(model.getSerie());
        entity.setSecuencia(model.getSecuencia());
        entity.setFecha(model.getFecha());
        entity.setTipoBeneficiario(model.getTipoBeneficiario());
        entity.setBeneficiarioDocumento(model.getBeneficiarioDocumento());
        entity.setBeneficiarioDireccion(model.getBeneficiarioDireccion());
        entity.setObservacion(model.getObservacion());
        entity.setMetodoPago(model.getMetodoPago());
        entity.setMontoRecibido(model.getMontoRecibido());
        entity.setVuelto(model.getVuelto());
        entity.setTotal(model.getTotal());
        entity.setEstado(model.getEstado());

        // Relaciones con solo el ID (proxies)
        TipoPagoEntity tipoPago = new TipoPagoEntity();
        tipoPago.setTipoPagoId(model.getTipoPagoId());
        entity.setTipoPagoEntity(tipoPago);

        TipoDocumentoEntity tipoDocumento = new TipoDocumentoEntity();
        tipoDocumento.setTipoDocumentoId(model.getTipoDocumentoId());
        entity.setTipoDocumentoEntity(tipoDocumento);

        AlmacenEntity almacen = new AlmacenEntity();
        almacen.setAlmacenId(model.getAlmacenId());
        entity.setAlmacenEntity(almacen);

        PacienteEntity beneficiario = new PacienteEntity();
        beneficiario.setPacienteId(model.getBeneficiarioId());
        entity.setBeneficiarioId(beneficiario);

        TipoTarjetaEntity tarjeta = new TipoTarjetaEntity();
        tarjeta.setTipoTarjetaId(model.getTipoTarjetaId());
        entity.setTipoTarjetaEntity(tarjeta);

        MonedaEntity moneda = new MonedaEntity();
        moneda.setMonedaId(model.getTipoMonedaId());
        entity.setTipoMonedaEntity(moneda);

        // Detalles
        List<VentaDetalleEntity> detalleEntities = model.getDetalles().stream()
                            .map(d -> VentaDetalleDboMapper.toEntity(d, entity, hospitalId, userId))
                            .collect(Collectors.toList());
        entity.setDetalle(detalleEntities);

        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;

    }

    public static Venta toDomain(VentaEntity entity) {

        List<VentaDetalle> detalles = entity.getDetalle().stream()
                .map(VentaDetalleDboMapper::toDomain)
                .collect(Collectors.toList());

        return new Venta(entity.getVentaId(),
                entity.getSerie(), entity.getSecuencia(), entity.getFecha(), entity.getTipoBeneficiario(),
                entity.getBeneficiarioDocumento(), entity.getBeneficiarioDireccion(),
                entity.getTipoPagoEntity().getTipoPagoId(), entity.getObservacion(), entity.getMetodoPago(),
                entity.getMontoRecibido(), entity.getVuelto(), entity.getTotal(),
                entity.getTipoDocumentoEntity().getTipoDocumentoId(), entity.getAlmacenEntity().getAlmacenId(),
                entity.getBeneficiarioId().getPacienteId(), entity.getTipoTarjetaEntity().getTipoTarjetaId(),
                entity.getTipoMonedaEntity().getMonedaId(), entity.getEstado(), detalles);

    }

}

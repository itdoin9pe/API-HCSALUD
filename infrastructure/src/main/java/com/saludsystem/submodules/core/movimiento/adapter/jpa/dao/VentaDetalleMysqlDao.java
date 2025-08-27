package com.saludsystem.submodules.core.movimiento.adapter.jpa.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.movimiento.adapter.jpa.VentaDetalleJpaRepository;
import com.saludsystem.submodules.core.movimiento.adapter.mapper.VentaDetalleDboMapper;
import com.saludsystem.submodules.movimiento.model.VentaDetalle;
import com.saludsystem.submodules.movimiento.model.constant.VentaDetalleConstant;
import com.saludsystem.submodules.movimiento.port.dao.VentaDetalleDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class VentaDetalleMysqlDao implements VentaDetalleDao {

	private final VentaDetalleJpaRepository ventaDetalleJpaRepository;
	
	/**
	 * @param ventaDetalleJpaRepository
	 */
	public VentaDetalleMysqlDao(VentaDetalleJpaRepository ventaDetalleJpaRepository) {
		this.ventaDetalleJpaRepository = ventaDetalleJpaRepository;
	}

	@Override
	public VentaDetalle getById(UUID uuid) {
		// TODO Auto-generated method stub
		return ventaDetalleJpaRepository.findById(uuid)
				.map(VentaDetalleDboMapper::toDomain)
				.orElseThrow( () -> new ResourceNotFoundException(VentaDetalleConstant.INVALID_ID));
	}

	@Override
	public ListResponse<VentaDetalle> getAll(UUID hospitalId, int page, int rows) {
		// TODO Auto-generated method stub
        var pageable = PageRequest.of(page - 1, rows);
        var pageResult = ventaDetalleJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
        List<VentaDetalle> data = pageResult.getContent()
                .stream()
                .map(VentaDetalleDboMapper::toDomain)
                .toList();
        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);
	}

	@Override
	public List<VentaDetalle> getList() {
		// TODO Auto-generated method stub
		return ventaDetalleJpaRepository.findAll()
				.stream()
				.map(VentaDetalleDboMapper::toDomain)
				.toList();
	}

}

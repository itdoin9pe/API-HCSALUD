package com.saludsystem.submodules.core.mantenimiento.adapter.jpa.dao;

import com.saludsystem.submodules.core.mantenimiento.adapter.jpa.BancoJpaRepository;
import com.saludsystem.submodules.core.mantenimiento.adapter.mapper.BancoDboMapper;
import com.saludsystem.submodules.mantenimiento.model.Banco;
import com.saludsystem.submodules.mantenimiento.port.dao.BancoDao;
import com.saludsystem.submodules.response.ListResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class BancoMysqlDao implements BancoDao {

    private final BancoJpaRepository bancoJpaRepository;

    public BancoMysqlDao(BancoJpaRepository bancoJpaRepository) {
        this.bancoJpaRepository = bancoJpaRepository;
    }

    @Override
    public Banco getById(UUID uuid) {
        return bancoJpaRepository.findById(uuid).map(BancoDboMapper::toDomain).orElse(null);
    }

    @Override
    public ListResponse<Banco> getAll(UUID hospitalId, int page, int rows) {

        var pageable = PageRequest.of(page - 1, rows);

        var pageResult = bancoJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);

        List<Banco> data = pageResult.getContent()
                .stream()
                .map(BancoDboMapper::toDomain)
                .toList();

        return new ListResponse<>(data, pageResult.getTotalElements(),
                pageResult.getTotalPages(), page);

    }

    @Override
    public List<Banco> getList() {
        return bancoJpaRepository.findAll().stream().map(BancoDboMapper::toDomain).toList();
    }
}

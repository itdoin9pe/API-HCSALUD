package com.saludsystem.submodules.core.medico.adapter.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludsystem.submodules.medico.mapper.DoctorMapper;
import com.saludsystem.submodules.medico.port.dao.DoctorDao;
import com.saludsystem.submodules.medico.port.repository.DoctorRepository;
import com.saludsystem.submodules.medico.service.DoctorCreateService;
import com.saludsystem.submodules.medico.service.DoctorDeleteService;
import com.saludsystem.submodules.medico.service.DoctorEditService;

@Configuration
public class DoctoBean
{
	@Bean
	public DoctorMapper doctorMapper()
	{
		return new DoctorMapper();
	}

	@Bean
	public DoctorCreateService doctorCreateService(DoctorRepository repository)
	{
		return new DoctorCreateService(repository);
	}

	@Bean
	public DoctorEditService doctorEditService(DoctorDao dao, DoctorRepository repository)
	{
		return new DoctorEditService(dao, repository);
	}

	@Bean
	public DoctorDeleteService doctorDeleteService(DoctorRepository repository, DoctorDao dao)
	{
		return new DoctorDeleteService(repository, dao);
	}
}

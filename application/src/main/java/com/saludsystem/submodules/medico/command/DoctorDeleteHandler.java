package com.saludsystem.submodules.medico.command;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.medico.service.DoctorDeleteService;

@Component
public class DoctorDeleteHandler
{
	private final DoctorDeleteService doctorDeleteService;

	public DoctorDeleteHandler(DoctorDeleteService doctorDeleteService)
	{
		this.doctorDeleteService = doctorDeleteService;
	}

	public void execute(UUID uuid)
	{
		doctorDeleteService.execute(uuid);
	}
}
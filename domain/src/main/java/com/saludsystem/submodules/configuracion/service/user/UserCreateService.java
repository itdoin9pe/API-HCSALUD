package com.saludsystem.submodules.configuracion.service.user;

import com.saludsystem.submodules.configuracion.model.Usuario;
import com.saludsystem.submodules.configuracion.port.in.repository.UserRepository;

public class UserCreateService
{
	private final UserRepository userRepository;

	public UserCreateService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	public Usuario execute(Usuario usuario)
	{
		return userRepository.save(usuario);
	}
}

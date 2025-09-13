package com.saludsystem.submodules.configuracion.mapper;

import java.util.UUID;

import com.saludsystem.submodules.configuracion.model.Usuario;
import com.saludsystem.submodules.configuracion.model.dtos.UsuarioDTO;
import com.saludsystem.submodules.configuracion.model.dtos.auth.NewUserDto;
import com.saludsystem.submodules.configuracion.model.dtos.command.edit.UsuarioEditCommand;
import com.saludsystem.submodules.configuracion.model.vo.usuario.Apellido;
import com.saludsystem.submodules.configuracion.model.vo.usuario.Direccion;
import com.saludsystem.submodules.configuracion.model.vo.usuario.Email;
import com.saludsystem.submodules.configuracion.model.vo.usuario.EstadoUsuario;
import com.saludsystem.submodules.configuracion.model.vo.usuario.Foto;
import com.saludsystem.submodules.configuracion.model.vo.usuario.Nombre;
import com.saludsystem.submodules.configuracion.model.vo.usuario.NumeroDocumento;
import com.saludsystem.submodules.configuracion.model.vo.usuario.Password;
import com.saludsystem.submodules.configuracion.model.vo.usuario.PhoneNumber;
import com.saludsystem.submodules.configuracion.model.vo.usuario.TipoDocumentoUsuario;
import com.saludsystem.submodules.configuracion.model.vo.usuario.UserHospital;
import com.saludsystem.submodules.configuracion.model.vo.usuario.UserId;
import com.saludsystem.submodules.configuracion.model.vo.usuario.UserRole;
import com.saludsystem.submodules.configuracion.model.vo.usuario.Username;

public class UsuarioMapper
{
	public Usuario fromCreateDto(NewUserDto dto)
	{
		return new Usuario(null, new Apellido(dto.getLastName()), new Nombre(dto.getFirstName()),
				new Email(dto.getEmail()), new Username(dto.getUsername()), new Password(dto.getPassword()),
				new PhoneNumber(dto.getPhoneNumber()), new Direccion(dto.getAddress()),
				new TipoDocumentoUsuario(dto.getDocumentType()), new NumeroDocumento(dto.getDocumentNumber()),
				new Foto(dto.getPhoto()), new UserRole(dto.getRoleId()), new UserHospital(dto.getHospitalId()),
				new EstadoUsuario(dto.getEstado()));
	}

	public Usuario fromUpdateDto(UUID uuid, UsuarioEditCommand dto)
	{
		return new Usuario(new UserId(dto.getUserId()), new Apellido(dto.getLastName()), new Nombre(dto.getFirstName()),
				new Email(dto.getEmail()), new Username(dto.getUsername()), new Password(dto.getPassword()),
				new PhoneNumber(dto.getPhoneNumber()), new Direccion(dto.getAddress()),
				new TipoDocumentoUsuario(dto.getDocumentType()), new NumeroDocumento(dto.getDocumentNumber()),
				new Foto(dto.getPhoto()), new UserRole(dto.getRoleId()), new UserHospital(dto.getHospitalId()),
				new EstadoUsuario(dto.getEstado()));
	}

	public UsuarioDTO toDto(Usuario model)
	{
		return new UsuarioDTO(model.getId().value(), model.getLastName().value(), model.getFirstName().value(),
				model.getEmail().value(), model.getUsername().value(), model.getPhoneNumber().value(),
				model.getAddress().value(), model.getDocumentType().value(), model.getDocumentNumber().value(),
				model.getPhoto().url(), model.getRolId().value(), model.getHospitalId().value(),
				model.getEstado().value());
	}
}
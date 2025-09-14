package com.saludsystem.submodules.core.configuracion.rest.controller.command;

import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.configuracion.command.create.UsuarioCreateHandler;
import com.saludsystem.submodules.configuracion.command.delete.UsuarioDeleteHandler;
import com.saludsystem.submodules.configuracion.command.edit.UsuarioEditHandler;
import com.saludsystem.submodules.configuracion.model.constant.UserConstant;
import com.saludsystem.submodules.configuracion.model.dtos.auth.NewUserDto;
import com.saludsystem.submodules.configuracion.model.dtos.command.edit.UsuarioEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Usuarios")
@RestController
@RequestMapping("/api/Usuarios")
public class UsuarioCommandController
{
	private final UsuarioCreateHandler createHandler;
	private final UsuarioEditHandler editHandler;
	private final UsuarioDeleteHandler deleteHandler;

	public UsuarioCommandController(
		UsuarioCreateHandler createHandler,
		UsuarioEditHandler editHandler,
		UsuarioDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
	@PostMapping(value = "/Save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ApiResponse createUser(@Valid @RequestBody NewUserDto dto)
	{
		createHandler.execute(dto);
		return new ApiResponse(true, UserConstant.CREATED);
	}

	@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
	@PutMapping(value = "/Update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ApiResponse updateUser(@PathVariable UUID uuid, @RequestBody UsuarioEditCommand dto)
	{
		editHandler.execute(uuid, dto);
		return new ApiResponse(true, UserConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{userId}")
	public ApiResponse deleteUser(@PathVariable UUID userId)
	{
		deleteHandler.execute(userId);
		return new ApiResponse(true, UserConstant.DELETED);
	}
}
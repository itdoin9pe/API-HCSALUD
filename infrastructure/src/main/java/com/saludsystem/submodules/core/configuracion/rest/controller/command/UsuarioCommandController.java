package com.saludsystem.submodules.core.configuracion.rest.controller.command;

import com.saludsystem.submodules.configuracion.command.create.UsuarioCreateHandler;
import com.saludsystem.submodules.configuracion.command.delete.UsuarioDeleteHandler;
import com.saludsystem.submodules.configuracion.command.edit.UsuarioEditHandler;
import com.saludsystem.submodules.configuracion.model.constant.UserConstant;
import com.saludsystem.submodules.configuracion.model.dtos.UsuarioDTO;
import com.saludsystem.submodules.configuracion.model.dtos.auth.NewUserDto;
import com.saludsystem.submodules.configuracion.model.dtos.command.edit.UsuarioEditCommand;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.response.ApiResponse;
import com.saludsystem.submodules.security.PublicUserRegistrationService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@Tag(name = "Usuarios")
@RestController
@RequestMapping("/api/Usuarios")
public class UsuarioCommandController
{
	private final UsuarioCreateHandler createHandler;
	private final UsuarioEditHandler editHandler;
	private final UsuarioDeleteHandler deleteHandler;

	private final PublicUserRegistrationService usuarioPublicRegistrationService;

	public UsuarioCommandController(
		UsuarioCreateHandler createHandler,
		UsuarioEditHandler editHandler,
		UsuarioDeleteHandler deleteHandler,
		PublicUserRegistrationService usuarioPublicRegistrationService)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
		this.usuarioPublicRegistrationService = usuarioPublicRegistrationService;
	}

	@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
			description = "Success", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
	@PostMapping(value = "/Save", consumes = MediaType.APPLICATION_JSON_VALUE)
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

	@PostMapping("/SaveNotSecure")
	public ResponseEntity<?> saveUsuario(@RequestBody NewUserDto request) {
		try {
			UserEntity nuevoUsuario = usuarioPublicRegistrationService.registrarUsuarioPublico(request);

			return ResponseEntity.ok(Map.of(
					"success", true,
					"message", "Usuario creado exitosamente",
					"data", Map.of(
							"userId", nuevoUsuario.getUserId(),
							"username", nuevoUsuario.getUsername(),
							"email", nuevoUsuario.getEmail()
					)
			));

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(Map.of(
					"success", false,
					"message", "Error al crear usuario: " + e.getMessage()
			));
		}
	}
}
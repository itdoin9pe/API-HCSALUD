package com.saludsystem.submodules.core.configuracion.rest.controller.command;

import com.saludsystem.submodules.configuracion.dtos.post.NewUserDto;
import com.saludsystem.submodules.configuracion.dtos.put.ActualizarUsuarioDTO;
import com.saludsystem.submodules.configuracion.constant.UserConstant;
import com.saludsystem.submodules.configuracion.command.create.UsuarioCreateHandler;
import com.saludsystem.submodules.configuracion.command.delete.UsuarioDeleteHandler;
import com.saludsystem.submodules.configuracion.command.edit.UsuarioEditHandler;
import com.saludsystem.submodules.response.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Usuarios")
@RestController
@RequestMapping("/api/Usuarios")
public class UsuarioCommandController {

  private final UsuarioCreateHandler createHandler;
  private final UsuarioEditHandler editHandler;
  private final UsuarioDeleteHandler deleteHandler;

  public UsuarioCommandController(UsuarioCreateHandler createHandler, UsuarioEditHandler editHandler, UsuarioDeleteHandler deleteHandler) {
    this.createHandler = createHandler;
    this.editHandler = editHandler;
    this.deleteHandler = deleteHandler;
  }

  @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success",
          content = @Content(schema = @Schema(implementation = ApiResponse.class)))
  //@PostMapping(value = "/Save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  @PostMapping(value = "/Save")
  public ApiResponse createUser(@Valid @RequestBody NewUserDto dto) {
    createHandler.execute(dto);
    return new ApiResponse(true, UserConstant.CREATED);
  }

  @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success",
          content = @Content(schema = @Schema(implementation = ApiResponse.class)))
  @PutMapping(value = "/Update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ApiResponse updateUser(@PathVariable UUID uuid, @RequestBody ActualizarUsuarioDTO dto) {
    editHandler.execute(uuid, dto);
    return new ApiResponse(true, UserConstant.UPDATED);
  }

  @DeleteMapping("/Delete/{userId}")
  public ApiResponse deleteUser(@PathVariable UUID userId) {
    deleteHandler.execute(userId);
    return new ApiResponse(true, UserConstant.DELETED);
  }

}
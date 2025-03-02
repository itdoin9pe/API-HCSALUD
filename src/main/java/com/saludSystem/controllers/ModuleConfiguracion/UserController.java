package com.saludSystem.controllers.ModuleConfiguracion;

import com.saludSystem.dtos.configuration.User.NewUserDto;
import com.saludSystem.dtos.configuration.User.ActualizarUsuarioDTO;
import com.saludSystem.dtos.configuration.User.UsuarioDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.Configuration.UsuarioResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.entities.User;
import com.saludSystem.repositories.modules.Configuration.UserRepository;
import com.saludSystem.services.FileStorageService;
import com.saludSystem.services.modules.configuration.User.UsuarioService;
import com.saludSystem.util.Util;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Tag(name = "Usuarios")
@RestController
@RequestMapping("/api/Usuarios")
public class UserController {

    private final UsuarioService usuarioService;
    private final FileStorageService fileStorageService;
    private final UserRepository userRepository;

    public UserController(UsuarioService usuarioService, FileStorageService fileStorageService, UserRepository userRepository) {
        this.usuarioService = usuarioService;
        this.fileStorageService = fileStorageService;
        this.userRepository = userRepository;
    }

    @GetMapping("/GetAllUsuario")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioResponse.class)))
    })
    public ListResponse<UsuarioDTO> getAllUsuario(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return usuarioService.getAllUsuario(hospitalId, page, rows);
    }

    @PostMapping("/SaveUsuario")
    public ResponseEntity<ApiResponse> stored(
            @RequestParam("photo")MultipartFile photo, @RequestParam("lastName") String lastName,
            @RequestParam("firstName") String firstName, @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("address") String address, @RequestParam("email") String email,
            @RequestParam("documentType") String documentType, @RequestParam("documentNumber") String documentNumber,
            @RequestParam("username") String username, @RequestParam("password") String password,
            @RequestParam("estado") Integer estado, @RequestParam("roleId") UUID roleId) throws IOException{
        String photoPath = fileStorageService.storeFile(photo);
        NewUserDto newUserDto = new NewUserDto();
        newUserDto.setLastName(lastName);
        newUserDto.setFirstName(firstName);
        newUserDto.setPhoneNumber(phoneNumber);
        newUserDto.setAddress(address);
        newUserDto.setEmail(email);
        newUserDto.setDocumentType(documentType);
        newUserDto.setDocumentNumber(documentNumber);
        newUserDto.setPhoto(photoPath);
        newUserDto.setUsername(username);
        newUserDto.setPassword(password);
        newUserDto.setEstado(estado);
        newUserDto.setRoleId(roleId);
        usuarioService.saveUsuario(newUserDto);
        return ResponseEntity.ok(new ApiResponse(true, "Usuario registrado correctamente"));
    }

    @PutMapping("/UpdateUsuario/{userId}")
    public ResponseEntity<ApiResponse> updateUsuario(
            @PathVariable("userId") UUID userId,
            @Valid @RequestParam(value = "photo", required = false) MultipartFile photo,
            @RequestParam("lastName") String lastName, @RequestParam("firstName") String firstName,
            @RequestParam("phoneNumber") String phoneNumber, @RequestParam("address") String address,
            @RequestParam("email") String email, @RequestParam("documentType") String documentType,
            @RequestParam("documentNumber") String documentNumber, @RequestParam("username") String username,
            @RequestParam("password") String password, @RequestParam("estado") Integer estado,
            @RequestParam("roleId") UUID roleId) throws IOException {
        ActualizarUsuarioDTO actualizarUsuarioDTO = new ActualizarUsuarioDTO();
        actualizarUsuarioDTO.setUserId(userId);
        actualizarUsuarioDTO.setLastName(lastName);
        actualizarUsuarioDTO.setFirstName(firstName);
        actualizarUsuarioDTO.setPhoneNumber(phoneNumber);
        actualizarUsuarioDTO.setAddress(address);
        actualizarUsuarioDTO.setEmail(email);
        actualizarUsuarioDTO.setDocumentType(documentType);
        actualizarUsuarioDTO.setDocumentNumber(documentNumber);
        actualizarUsuarioDTO.setUsername(username);
        actualizarUsuarioDTO.setPassword(password);
        actualizarUsuarioDTO.setRoleId(roleId);
        // Si se proporciona una nueva imagen, guardarla y actualizar la ruta
        if (photo != null && !photo.isEmpty()) {
            // Eliminar la imagen antigua si existe
            User existingUser = userRepository.findById(userId).orElseThrow();
            if (existingUser.getPhoto() != null) {
                fileStorageService.deleteFile(existingUser.getPhoto());
            }

            // Guardar la nueva imagen
            String photoPath = fileStorageService.storeFile(photo);
            actualizarUsuarioDTO.setPhoto(photoPath);
        }
        /*
        if (photo != null) {
            actualizarUsuarioDTO.setPhoto(Util.compressZLib(photo.getBytes()));
        }*/
        actualizarUsuarioDTO.setEstado(estado);
        usuarioService.updateUsuario(userId, actualizarUsuarioDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Usuario Actualizado correctamente"));
    }

    @DeleteMapping("/DeleteUsuario/{userId}")
    public ApiResponse destroy(@PathVariable UUID userId) {
        return usuarioService.deleteUsuario(userId);
    }

}
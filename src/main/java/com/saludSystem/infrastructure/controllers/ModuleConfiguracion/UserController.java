package com.saludSystem.infrastructure.controllers.ModuleConfiguracion;

import com.saludSystem.application.dtos.Configuracion.User.NewUserDto;
import com.saludSystem.application.dtos.Configuracion.User.ActualizarUsuarioDTO;
import com.saludSystem.application.dtos.Configuracion.User.UsuarioDTO;
import com.saludSystem.application.dtos.responses.ApiResponse;
import com.saludSystem.application.dtos.responses.Configuracion.UsuarioResponse;
import com.saludSystem.application.dtos.responses.ListResponse;
import com.saludSystem.domain.entities.Configuracion.User;
import com.saludSystem.infrastructure.repositories.modules.Configuracion.UserRepository;
import com.saludSystem.application.services.FileStorageService;
import com.saludSystem.application.services.modules.Configuracion.User.UsuarioService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
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

    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success",
            content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    @PostMapping(value = "/SaveUsuario", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse> stored(
            String lastName, String firstName, String phoneNumber, String address, String email,
            String documentType, String documentNumber, String username,  String password, Integer estado, MultipartFile photo,
            UUID roleId) throws IOException{
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

    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success",
            content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    @PutMapping(value = "/UpdateUsuario/{userId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse> updateUsuario(
            @PathVariable("userId") UUID userId, String lastName, String firstName, String phoneNumber, String address,
            String email, String documentType, String documentNumber,String username, String password, Integer estado,
            UUID roleId, MultipartFile photo) throws IOException {
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
        if (photo != null && !photo.isEmpty()) {
            User existingUser = userRepository.findById(userId).orElseThrow();
            if (existingUser.getPhoto() != null) {
                fileStorageService.deleteFile(existingUser.getPhoto());
            }
            String photoPath = fileStorageService.storeFile(photo);
            actualizarUsuarioDTO.setPhoto(photoPath);
        }
        actualizarUsuarioDTO.setEstado(estado);
        usuarioService.updateUsuario(userId, actualizarUsuarioDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Usuario Actualizado correctamente"));
    }

    @DeleteMapping("/DeleteUsuario/{userId}")
    public ApiResponse destroy(@PathVariable UUID userId) {
        return usuarioService.deleteUsuario(userId);
    }

}
package com.saludsystem.submodules;

import com.saludsystem.submodules.configuracion.model.entity.Usuario;
import com.saludsystem.submodules.configuracion.model.entity.value_objet.usuario.*;
import com.saludsystem.submodules.configuracion.port.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

@Configuration
public class AdminInitializer {
    @Bean
    public CommandLineRunner initAdmin(UserRepository userRepository) {
        return args -> {
            if (userRepository.count() == 0) {
                Usuario admin = new Usuario(
                        new UserId(UUID.randomUUID()),
                        new Apellido("Admin"),
                        new Nombre("Super"),
                        new Email("admin@syssalud.com"),
                        new Username("adminUser"),
                        new Password(new BCryptPasswordEncoder().encode("adminadmin")),
                        new PhoneNumber("939442331"),
                        new Direccion("Sin dirección"),
                        new TipoDocumentoUsuario("DNI"),
                        new NumeroDocumento("72881622"),
                        new Foto(""),
                        new UserRole(UUID.fromString("d947ea19-503f-487f-9270-d8a5d466fa8b")),
                        new UserHospital(UUID.fromString("d7ca061a-ba19-4d63-90cf-28ac5046a590")), // Hospital por defecto
                        new EstadoUsuario(1)
                );
                userRepository.saveSinSeguridad(admin);
                System.out.println("✅ Usuario admin creado con éxito.");
            } else {
                System.out.println("ℹ️ Ya existen usuarios. No se crea admin.");
            }
        };
    }
}

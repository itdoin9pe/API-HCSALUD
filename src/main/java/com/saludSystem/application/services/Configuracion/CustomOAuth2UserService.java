/*
package com.saludSystem.application.services.Configuracion;

import com.saludSystem.application.dtos.Configuracion.POST.NewUserDto;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.security.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        // Procesar la información del usuario
        Map<String, Object> attributes = oAuth2User.getAttributes();
        String email = (String) attributes.get("email");

        // Buscar o crear el usuario en tu sistema
        UserEntity user = userService.findEntityByEmail(email);

        // Crear UserDetails
        UserDetails userDetails = userService.loadUserByUsername(email);

        // Generar tokens JWT
        String jwtToken = jwtUtil.generateToken(
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()));
        String refreshToken = jwtUtil.generateRefreshToken(userDetails);

        // Agregar tokens a los atributos
        attributes.put("access_token", jwtToken);
        attributes.put("refresh_token", refreshToken);

        return new DefaultOAuth2User(
                userDetails.getAuthorities(),
                attributes,
                userRequest.getClientRegistration().getProviderDetails()
                        .getUserInfoEndpoint().getUserNameAttributeName());
    }
}
*/
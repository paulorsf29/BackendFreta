package com.freta.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configuração CORS mais abrangente
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*");  // Permite todas origens
        config.addAllowedHeader("*");         // Permite todos headers
        config.addAllowedMethod("*");         // Permite todos métodos HTTP
        source.registerCorsConfiguration("/**", config);

        http
            .cors(cors -> cors.configurationSource(source))  // Aplica configuração CORS
            .csrf(csrf -> csrf.disable())                   // Desabilita CSRF
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()  // Permite TODAS requisições sem autenticação
            );
        
        return http.build();
    }
}
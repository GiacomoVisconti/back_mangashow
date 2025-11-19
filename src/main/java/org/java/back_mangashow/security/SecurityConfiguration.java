package org.java.back_mangashow.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
    @Bean
    @SuppressWarnings("removal")
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(requests -> requests 
        .requestMatchers("/mangas/create", "/mangas/edit/**").hasAuthority("ADMIN")
        .requestMatchers(HttpMethod.POST, "/mangas/**").hasAuthority("ADMIN")
        .requestMatchers("/authors/create", "/authors/edit/**").hasAuthority("ADMIN")
        .requestMatchers(HttpMethod.POST, "/authors/**").hasAuthority("ADMIN")
        .requestMatchers("/mangas", "/mangas/**").hasAnyAuthority("USER", "ADMIN")
        .requestMatchers("/").permitAll()
        .requestMatchers("/**").permitAll())
        .formLogin(Customizer.withDefaults())
        .cors(cors -> cors.disable())
        .csrf(csrf -> csrf.disable());

        return http.build();
    }


    @Bean
    @SuppressWarnings("deprecation")
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());

        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    DatabaseUserDetailsService userDetailsService(){
        return new DatabaseUserDetailsService();
    }

    @Bean
    PasswordEncoder passwordEncoder(){

        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}

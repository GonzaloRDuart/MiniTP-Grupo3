package com.utn.frba.relacionamientopersonas.config;


import com.utn.frba.relacionamientopersonas.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    //Necesario para evitar que la seguridad se aplique a los resources
    //Como los css, imagenes y javascripts
    String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                    .antMatchers(resources).permitAll()
                    .antMatchers("/","/index").permitAll()
                    .antMatchers("/registrarse").permitAll()
                    .antMatchers("/menuUsuario").access("hasRole('USER')")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .defaultSuccessUrl("/menuUsuario")
                    .failureUrl("/login?error=true")
                    .usernameParameter("username")
                    .and()
                .logout()
                    .permitAll()
                    .logoutSuccessUrl("/login?logout");
    }

    BCryptPasswordEncoder bCryptPasswordEncoder;
    //Crea el encriptador de contraseñas
     @Bean
     public BCryptPasswordEncoder passwordEncoder() {
          bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
         return bCryptPasswordEncoder;
    }

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    //Registra el service para usuarios y el encriptador de contrasena
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

}
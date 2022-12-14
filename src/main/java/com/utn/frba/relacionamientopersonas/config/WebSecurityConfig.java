package com.utn.frba.relacionamientopersonas.config;



import com.utn.frba.relacionamientopersonas.service.apiServices.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;



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
                    .antMatchers("/validacion").permitAll()
                    .antMatchers("/menuUsuario").permitAll()
                    .antMatchers("/actualizarDatos").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .defaultSuccessUrl("/menuUsuario")
                    .failureUrl("/login?error=true")
                    .and()
                .logout()
                    .permitAll()
                    .logoutSuccessUrl("/login?logout");
    }

    @Autowired
    IUsuarioService userDetailsService;

    //Registra el service para usuarios y el encriptador de contrasena??
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

}
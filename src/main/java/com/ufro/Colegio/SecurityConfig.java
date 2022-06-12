package com.ufro.Colegio;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    String[] resources = {"/style.css"};

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(resources).permitAll()
                .antMatchers("/","/ver-cursos", "/ver-alumnos","/registrar-alumno/nuevo-alumno","/registrar-curso/nuevo-curso","/registrar-alumno","/registrar-curso","/ver-curso**","/ver-alumno**").permitAll()
                .anyRequest().authenticated();
        }
    }



package com.webapp7.webapp7.security;

import java.security.SecureRandom;

import com.webapp7.webapp7.security.RepositoryUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    RepositoryUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10, new SecureRandom());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override //DE AQUI SOL)O CAMBIAR ESTO
    protected void configure(HttpSecurity http) throws Exception {
        // DECIDIR QUE PAGINAS SON PUBLICAS O PRIVADAS
        // Public pages
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/login_error").permitAll();
        http.authorizeRequests().antMatchers("/logout").permitAll();
        http.authorizeRequests().antMatchers("/index").permitAll();
        http.authorizeRequests().antMatchers("/about").permitAll();
        http.authorizeRequests().antMatchers("/blog").permitAll();
        http.authorizeRequests().antMatchers("/contact").permitAll();
        http.authorizeRequests().antMatchers("/course").permitAll();
        http.authorizeRequests().antMatchers("/blog-single").permitAll();


        // Private pages
/*
       http.authorizeRequests().antMatchers("/student").hasAnyRole("alumno");
        http.authorizeRequests().antMatchers("/user_instructor").hasAnyRole("profesor");
        http.authorizeRequests().antMatchers("/user_instructor").hasAnyRole("administrador");
        http.authorizeRequests().antMatchers("/admin").hasAnyRole("admisnistrador");
       // http.authorizeRequests().antMatchers("/email").hasAnyRole("alumno", "administrador", "profesor");



 */

        // Login form SE PUEDE DEJAR IGUAL SI MANTENEMOS LA URL de login, si no tocamos controlador del login
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/");
        http.formLogin().failureUrl("/login_error");

        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");


        http.csrf().disable();
    }

}
package com.webapp7.webapp7.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

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

    @Override
    protected void configure(HttpSecurity http) throws Exception {

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
        http.authorizeRequests().antMatchers("/instructor").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/comments/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/comments/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/posts/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/posts/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/users/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/users/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/users/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/courses/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/courses/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/courses/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/courses/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/materials/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/materials/**").permitAll();

        // Private pages

        http.authorizeRequests().antMatchers("/student").hasAnyRole("alumno");
        http.authorizeRequests().antMatchers("/user_instructor").hasAnyRole("profesor");
        http.authorizeRequests().antMatchers("/admin").hasAnyRole("administrador");
        http.authorizeRequests().antMatchers("/email").hasAnyRole("alumno", "administrador", "profesor");


        //Login pages
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/");
        http.formLogin().failureUrl("/login_error");

        //Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");

        http.csrf().disable();
    }

}
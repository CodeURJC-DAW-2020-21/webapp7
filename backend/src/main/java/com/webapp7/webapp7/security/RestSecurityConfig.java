package com.webapp7.webapp7.security;

import com.webapp7.webapp7.security.jwt.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@Order(1)
public class RestSecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("repositoryUserDetailsService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    //Expose AuthenticationManager as a Bean to be used in other services
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    protected void configure(HttpSecurity http) throws Exception {

        http.antMatcher("/api/**");

        //  Permitted only to administrador
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/posts").hasRole("administrador");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/admin/users").hasRole("administrador");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/admin/users").hasRole("administrador");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/admin/users/**").hasRole("administrador");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/admin/users/**/course/**").hasRole("administrador");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/admin/users/**/course/**").hasRole("administrador");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/courses").hasRole("administrador");
        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/courses/**").hasRole("administrador");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/courses/**").hasRole("administrador");

        //  Permitted only to instructor
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/materials").hasRole("profesor");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/materials/**").hasRole("profesor");

        //  Permitted only to student
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/comments").hasRole("alumno");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/materials").hasRole("alumno");

        // Permitted to every user
        http.authorizeRequests().anyRequest().permitAll();

        // Disable CSRF protection (it is difficult to implement in REST APIs)
        http.csrf().disable();

        // Disable Http Basic Authentication
        http.httpBasic().disable();

        // Disable Form login Authentication
        http.formLogin().disable();

        // Avoid creating session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Add JWT Token filter
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }


}




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
/*
@Configuration
public class RestSecurityConfig extends WebSecurityConfigurerAdapter {

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

    protected void configure(HttpSecurity http) throws Exception{

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



        //  Permitted to every user
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/posts/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/comments/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/admin/courses/**").permitAll();

        //  Permitted only to admin
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/posts/").hasRole("admin");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "api/admin/users/**").hasRole("admin");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "api/admin/users/").hasRole("admin");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "api/admin/users/**").hasRole("admin");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "api/admin/users/** / course/**").hasRole("admin");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "api/admin/users/** / course/**").hasRole("admin");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/courses/").hasRole("admin");
        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/courses/**").hasRole("admin");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/courses/**").hasRole("admin");

        //  Permitted only to instructor
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/materials/").hasRole("profesor");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/materials/**").hasRole("profesor");

        //  Permitted only to student
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/comments/").hasRole("alumno");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/materials/**").hasRole("alumno");

        // Other endpoints are public
        http.authorizeRequests().anyRequest().permitAll();

        // Disable CSRF protection (it is difficult to implement in REST APIs)
        http.csrf().disable();

        // Enable Basic Authentication
        http.httpBasic();

        // Disable Form login Authentication
        http.formLogin().disable();

        // Avoid creating session (because every request has credentials)
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


}
 */


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.neosofttech.technologies;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

 

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) 
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
    .passwordEncoder(passwordEncoder())
    .withUser("user1")
    .password(passwordEncoder().encode("vikash126"))
    .roles("USER")
    .and()
            .withUser("user2").password(passwordEncoder().encode("vikash125")).roles("ADMIN", "USER");
   }
    
    
   @Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }
   
      
    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http.antMatcher("/**")  
            .authorizeRequests()                  
            .antMatchers("/").permitAll()
            .antMatchers(HttpMethod.PUT, "/blog/editblog/**").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and().formLogin();
            http.csrf().disable();
    }
   
    /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").hasAnyAuthority("USER", "CREATOR", "EDITOR", "ADMIN")
            .antMatchers("/blog/addblog").hasAnyAuthority("ADMIN", "CREATOR")
            .antMatchers("/blog/editblog/**").hasAnyAuthority("ADMIN", "EDITOR")
            .antMatchers("/delete/**").hasAuthority("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll()
            .and()
            .logout().permitAll()
            .and()
            .exceptionHandling().accessDeniedPage("/403")
             .csrf().disable();
            ;
    }
    */
   
    
}

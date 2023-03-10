package com.allstate.quickclaimsserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    //AUTHENTICATION
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    //AUTHORIZATION
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll();

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/claim/**")
                .hasAnyRole("USER", "MANAGER")

                .antMatchers(HttpMethod.GET, "/api/claim?policyNumber=**")
                .hasAnyRole("USER", "MANAGER")

                .antMatchers(HttpMethod.GET, "/api/claim/**/Notes/**")
                .hasAnyRole("USER", "MANAGER")

                .antMatchers(HttpMethod.POST, "/api/claim/**/Notes/**")
                .hasRole("MANAGER")

                .antMatchers(HttpMethod.GET, "/api/claim/**/Notes/")
                .hasAnyRole("USER", "MANAGER")

                .antMatchers(HttpMethod.GET, "/api/claim/")
                .hasAnyRole("USER", "MANAGER")

                .antMatchers(HttpMethod.POST, "/api/login")
                .hasAnyRole("USER", "MANAGER")

                .antMatchers(HttpMethod.POST, "/api/claim/**")
                .hasRole("MANAGER")

                .antMatchers(HttpMethod.PUT, "/api/claim/**")
                .hasRole("MANAGER")

                .and().csrf().disable()
                .httpBasic();
    }


}

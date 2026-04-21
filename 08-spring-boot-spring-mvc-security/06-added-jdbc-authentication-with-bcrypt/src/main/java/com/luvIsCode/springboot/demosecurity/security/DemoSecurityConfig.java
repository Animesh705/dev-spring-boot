package com.luvIsCode.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Controller
public class DemoSecurityConfig {
    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails jhon= User.builder()
                .username("jhon")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary= User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan= User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(jhon,mary,susan);
    }
     */

    //add support for jdbc(java database connectivity) ... no more hard coding
    //adding our own custom table instead pf default ones
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        //define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,pw,active from members where user_id=?");
        //define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=?");
        
        return jdbcUserDetailsManager;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configure ->
                configure
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
        )
                .formLogin(form ->
                        form
                                .loginPage("/showMyLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied")
                );
        return http.build();
    }
}

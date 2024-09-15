package com.myproject.library.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        
        return new JdbcUserDetailsManager(dataSource);
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("books/list").hasRole("USER")
                        .requestMatchers( "books/showFormforAdd").hasRole("ADMIN")
                        .requestMatchers( "books/showFormForUpdate").hasRole("ADMIN")
                        .anyRequest().authenticated()
                        )
                        .formLogin(form ->
                                form
                                        .loginPage("/showLoginPage")
                                        .loginProcessingUrl("/authenticateTheUser")
                                        .permitAll()
                        ).logout(logout -> logout.permitAll()
                        
                        );

          
        // use HTTP basic authentication
        // http.httpBasic();

        //disable Cross Site RequestForgery (CSRF)
        // http.csrf().disable();

        return http.build();
    }

}

package com.kloudspot.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfigurator extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/auth-api/**").permitAll()
                .antMatchers("/user-api/**").hasAnyRole("ADMIN")
                .antMatchers("/product-api/**").hasAnyRole("USER", "ADMIN");

        super.configure(http);
    }
}

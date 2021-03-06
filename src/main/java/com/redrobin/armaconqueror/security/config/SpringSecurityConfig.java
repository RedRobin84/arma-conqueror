package com.redrobin.armaconqueror.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
      /* http.authorizeRequests().anyRequest().permitAll();
        http.csrf().disable();*/

         http.
                authorizeRequests().
                antMatchers("/api/", "/register.xhtml", "/javax.faces.resource/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login.xhtml").failureUrl("/login.xhtml?error=true").successForwardUrl("/index.xhtml")
                .permitAll()
                .and().logout().logoutSuccessUrl("/login.xhtml")
                .and()
                .csrf().disable()
        .httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsService userDetailsService, PasswordEncoder encoder)
            throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
        auth.inMemoryAuthentication().withUser("john.doe") // todo: remove inMemoryUsers
                .password(encoder.encode("1234")).roles("USER").and()
                .withUser("jane.doe").password(encoder.encode("5678")).roles("ADMIN");
    }
}

package com.apl.brokr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityLayerConfig extends WebSecurityConfigurerAdapter {

    private final static String AUTHORITIES_BY_USERNAME_QUERY = "Select username, role_name From users_roles Where username = ?";
    private final static String USERS_BY_USERNAME_QUERY = "Select username, password, enabled From users Where username = ?";

    private final DataSource dataSource;

    public SecurityLayerConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .authoritiesByUsernameQuery(AUTHORITIES_BY_USERNAME_QUERY)
                .usersByUsernameQuery(USERS_BY_USERNAME_QUERY);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests()
               .antMatchers("/register", "/register/**").permitAll()
               .antMatchers ("/css/**", "/images/**").permitAll ()
               .antMatchers("/login", "/logout").authenticated()
               .antMatchers("/client", "/client/**").hasAnyRole("CLIENT", "BROKER", "ADMIN")
               .antMatchers("/broker", "/broker/**").hasAnyRole("BROKER", "ADMIN")
               .antMatchers("/admin", "/admin/**").hasRole("ADMIN")
               .anyRequest().authenticated()
               .and()
               .formLogin()
               .and()
               .httpBasic();
    }
}

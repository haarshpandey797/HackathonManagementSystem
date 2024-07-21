package com.nucleus.config;

import com.nucleus.service.security.PersonUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@ComponentScan("com.nucleus")
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    PersonUserDetails personUserDetails;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.userDetailsService(personUserDetails).passwordEncoder(getBCrypPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/resources/**").permitAll()
//                .antMatchers("/**").hasAnyAuthority("ADMIN", "JUDGE", "PARTICIPANT", "PROBLEMOWNER", "MARKETING")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/judge/**").hasRole("JUDGE")
                .antMatchers("/participant/**").hasRole("PARTICIPANT")
                .antMatchers("/problemOwner/**").hasRole("PROBLEMOWNER")
                .antMatchers("/marketing/**").hasRole("MARKETING")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .successHandler(customAuthenticationSuccessHandler())
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll();
    }

    @Bean
    public BCryptPasswordEncoder getBCrypPasswordEncoder(){
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }
}

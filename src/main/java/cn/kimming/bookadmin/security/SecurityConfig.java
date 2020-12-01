package cn.kimming.bookadmin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author: 刘铭轩KimmingLau
 * @Date: 2020-11-30 11:25
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().sameOrigin();;

        http.formLogin().loginPage("/login.html").loginProcessingUrl("/login")
                .successHandler(new MyAuthenticationSuccessHandler())
                .failureHandler(new MyAuthenticationFailureHandler())
                .permitAll().and();

        http
                .authorizeRequests()
                .antMatchers("/css/**", "/fonts/**", "/images/**", "/js/**").permitAll()
                .antMatchers("/pages/system/**").hasAnyRole("SYSTEM", "ROOT")
                .antMatchers("/pages/business/**").hasAnyRole("BOOK", "ROOT")
                .anyRequest().authenticated();
    }
}

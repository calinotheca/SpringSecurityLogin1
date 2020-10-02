package pl.springsecuritylogin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
  
  @Bean
  public PasswordEncoder passwordEncoder() {
    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    return passwordEncoder;
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception  {
    http
      .authorizeRequests()
        .antMatchers("/login*").permitAll()   
        
        // login page static elements allowed
        .antMatchers("/css/**").permitAll()
        .antMatchers("/fonts/**").permitAll()
        .antMatchers("/images/**").permitAll()
        .antMatchers("/js/**").permitAll()
        .antMatchers("/vendor/**").permitAll()
        .anyRequest().authenticated()
        .and()
      .formLogin()
        .loginPage("/login").permitAll()
        .and()
      .logout().permitAll()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))            
        .logoutSuccessUrl("/login")
        .invalidateHttpSession(true)       
        .deleteCookies("JSESSIONID")        
       .and()
       .exceptionHandling()
       .accessDeniedPage("/403");
  }

}
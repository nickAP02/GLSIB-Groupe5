package com.example.demo.controller;

import com.example.demo.model.Utilisateur;
import com.example.demo.service.MyUserDetailsService;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@RequestMapping({"/","/home"})
@Controller
public class homeController extends WebSecurityConfigurerAdapter {
    @Autowired
    MyUserDetailsService utilisateurService;
    RoleService roleService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/home/login").permitAll()
                .antMatchers("/users/user").hasAnyRole("USER","ADMIN")
                .antMatchers("/users/admin").hasRole("ADMIN")
                .antMatchers("/produit/**").hasRole("ADMIN")
                .antMatchers("/vente/**").hasRole("ADMIN")
                .antMatchers("/category/**").hasRole("ADMIN")
                .antMatchers("/appro/**").hasRole("ADMIN")
                .and().formLogin().loginPage("/home/login")
                .defaultSuccessUrl("/home/loginSuccess").failureUrl("/error/404")
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")
                .and().exceptionHandling().accessDeniedPage("/error/403");
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(utilisateurService);
        return daoAuthenticationProvider;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    @GetMapping({"/","/home","/login"})
    public String login(){
        return "Auth/login";
    }
    @GetMapping("/loginSuccess")
    public String loggedIn()
    {
        return "redirect:/users/user";
    }
    @GetMapping("/error/403")
    public String erreur403(){
        return "Error/403";
    }
    @GetMapping("/error/404")
    public String erreur404(){
        return "Error/404";
    }
}

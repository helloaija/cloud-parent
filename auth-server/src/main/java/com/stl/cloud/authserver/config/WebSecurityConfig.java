package com.stl.cloud.authserver.config;

import com.stl.cloud.authserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserService userService;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // http.formLogin().permitAll().and()
        //         .logout().logoutUrl("/logout").logoutSuccessUrl("/").and()
        //         // 所有请求都需要安全验证
        //         .authorizeRequests().anyRequest().authenticated()
        //         .and().csrf().disable()
        //         .httpBasic();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 配置验证用户信息源和密码加密策略
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     return new PasswordEncoder() {
    //         @Override
    //         public String encode(CharSequence charSequence) {
    //             return charSequence.toString();
    //         }
    //
    //         @Override
    //         public boolean matches(CharSequence charSequence, String s) {
    //             return Objects.equals(charSequence.toString(), s);
    //         }
    //     };
    // }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

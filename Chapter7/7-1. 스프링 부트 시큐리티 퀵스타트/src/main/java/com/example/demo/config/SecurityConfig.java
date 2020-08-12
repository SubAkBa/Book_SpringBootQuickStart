package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/member/**").authenticated();
		http.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");

		http.csrf().disable();
//		http.formLogin();
		http.formLogin().loginPage("/login").defaultSuccessUrl("/loginSuccess", true);
		http.exceptionHandling().accessDeniedPage("/accessDenied");
		http.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");
	}

	@Autowired
	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("manager").password("{noop}manager123").roles("MANAGER");

		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin123").roles("ADMIN");
	}
}

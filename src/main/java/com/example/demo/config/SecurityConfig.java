package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	PasswordEncoder encoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("india").password(encoder.encode("india")).roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.authorizeRequests()
//		.anyRequest()
//		.authenticated()
//		.and()
//		.httpBasic();
		
//		http
//		.authorizeRequests()
//		.antMatchers("/allStores/**")
//		.authenticated()
//		.and()
//		.httpBasic();
		
		http
		.rememberMe()
		.and()
		.authorizeRequests()
		.antMatchers("/allStores/**")
		.authenticated()
		.and()
		.httpBasic();
		
//		http.rememberMe();
	}

}

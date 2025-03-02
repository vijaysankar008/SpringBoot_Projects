package com.security.homepage.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.security.homepage.securityservice.AppUserSecurityService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	AppUserSecurityService appUserSecurityService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(authorize ->{
					authorize.requestMatchers("/admin/**").hasRole("ADMIN");
					authorize.requestMatchers("/user/**").hasRole("USER");
					authorize.anyRequest().authenticated();
					}
				).formLogin(form ->
			form.loginPage("/login")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/admin")
			.permitAll()
			);
		return httpSecurity.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return appUserSecurityService;
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(appUserSecurityService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

}

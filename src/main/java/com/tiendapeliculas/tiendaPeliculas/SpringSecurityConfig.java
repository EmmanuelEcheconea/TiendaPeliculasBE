package com.tiendapeliculas.tiendaPeliculas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.tiendapeliculas.tiendaPeliculas.token.FiltroJWTAutenticacion;
import com.tiendapeliculas.tiendaPeliculas.token.FiltroLogin;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception{
		PasswordEncoder encoder = passwordEncoder();
		UserBuilder users = User.builder().passwordEncoder(password -> encoder.encode(password));
		
		
		builder.inMemoryAuthentication()
		.withUser(users.username("admin").password("12345").roles("ADMIN","USER"));
		builder.inMemoryAuthentication()
		.withUser(users.username("emmanuel").password("3131").roles("USER"));
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.cors().and()
		.authorizeRequests().antMatchers(HttpMethod.POST,"/webapi/login").
		permitAll().anyRequest().authenticated().
		and().addFilterBefore(new FiltroLogin("/webapi/login",
		authenticationManager()), UsernamePasswordAuthenticationFilter.class)
		.addFilterBefore(new FiltroJWTAutenticacion(), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowCredentials(true);
		configuration.addAllowedOrigin("hhtp://localhost:8001");
		configuration.addAllowedHeader("*");
		configuration.addExposedHeader("Authorization");
		configuration.addAllowedMethod("*");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**",configuration);
		return source;
	}
	
}

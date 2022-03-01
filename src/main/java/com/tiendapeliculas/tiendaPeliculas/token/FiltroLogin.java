package com.tiendapeliculas.tiendaPeliculas.token;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiendapeliculas.tiendaPeliculas.model.Usuario;

public class FiltroLogin extends AbstractAuthenticationProcessingFilter {

	private HttpParserService httpParserService;

	public FiltroLogin(String url, AuthenticationManager manager) {
		super(url);
		httpParserService= new HttpParserService();
		setAuthenticationManager(manager);
	}

//validamos que el usuario sea  bueno par spring security
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
		Usuario usuario = new ObjectMapper().readValue(request.getInputStream(),Usuario.class);
		UsernamePasswordAuthenticationToken usuarioSpring = new UsernamePasswordAuthenticationToken(usuario.getNombre(), usuario.getContrasena());
		
		
		
		return getAuthenticationManager().authenticate(usuarioSpring);
	}

	//nos genera el token
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authentication) throws IOException, ServletException {

		String nombreUsuario = authentication.getName();
		httpParserService.createToken(response,nombreUsuario);
	}
	
	

}

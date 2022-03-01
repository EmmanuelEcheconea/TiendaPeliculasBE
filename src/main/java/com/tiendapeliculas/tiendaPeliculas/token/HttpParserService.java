package com.tiendapeliculas.tiendaPeliculas.token;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;


public class HttpParserService {

	private long expiracion = 360000;
	private String claveEncriptar = "superclave";
	private String prefijoToken = "barer";
	private String cabeceraHttp = "Authorization";
	
	public void createToken(HttpServletResponse response, String usuario) {
		String JWT = new TokenService().createToken(usuario, claveEncriptar, new Date(System.currentTimeMillis()+expiracion));
		response.addHeader(cabeceraHttp,prefijoToken + " "+ JWT);
	}
	
	public Authentication readToken(HttpServletRequest request) {
		String token = request.getHeader(cabeceraHttp);
		
		if(token != null) {
			String tokenReal = token.substring(token.indexOf(" ")+1);
			String usuario = new TokenService().readToken(tokenReal, claveEncriptar);
			if(usuario != null) {
				return new UsuarioAutentificado(usuario);
			}
		}	
		return null;
	}
}

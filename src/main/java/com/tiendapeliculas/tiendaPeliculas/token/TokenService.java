package com.tiendapeliculas.tiendaPeliculas.token;

import java.util.Base64;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenService {
	
	public String createToken(String usuario, String claveEncriptar, Date expiracion) {
		
		String JWT = Jwts.builder()
				.setSubject(usuario)
				.setExpiration(expiracion)
				.signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString((claveEncriptar.getBytes())))
				.compact();
		return JWT;
	}
	
	public String readToken(String token, String claveEncriptar) {
		String usuario = Jwts.parser()
				.setSigningKey(Base64.getEncoder().encodeToString((claveEncriptar.getBytes())))
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
		return usuario;
	}
}

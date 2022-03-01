package com.tiendapeliculas.tiendaPeliculas;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

import com.tiendapeliculas.tiendaPeliculas.token.TokenService;

class TokenTest {

	@Test
	void testCreateToken() throws ParseException {
		TokenService servicio = new TokenService();
		DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");		
		String token = servicio.createToken("Emmanuel", "superclave", formateador.parse("31/03/2022"));		
		System.out.println(token);
	}

	@Test
	void testReadToken() {
		TokenService servicio = new TokenService();
		String token = servicio.readToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJFbW1hbnVlbCIsImV4cCI6MTY0ODY5NTYwMH0.dVpjMmZFlTEyFqemXvA0moGCyuE5FM9O1Th-vNbdCKQ","superclave");		
		assertEquals("Emmanuel", token);
	}

}

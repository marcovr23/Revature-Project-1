package com.revature.util;

import java.util.Date;

import org.apache.log4j.Logger;

import com.revature.models.User;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtGenerator {
	
	private static Logger log = Logger.getLogger(JwtGenerator.class);
	
	public static String createJwt(User subject) {
		log.info("Creating new JWT for: " + subject.getUsername());
		
		// The JWT Signature Algorithm used to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		
		long nowMillis = System.currentTimeMillis();
		
		// Configure the JWT and set its claims
		JwtBuilder builder = Jwts.builder()
				.setId(Integer.toString(subject.getId()))
				.setSubject(subject.getUsername())
				.setIssuer("revature")
				.claim("role", subject.getRole())
				.setExpiration(new Date(nowMillis + JwtConfig.EXPIRATION * 1000))
				.signWith(signatureAlgorithm, JwtConfig.signingKey);
		
		log.info("JWT successfully created");
		
		// Build the JWT and serialize it into a compact, URL-safe string
		return builder.compact();
	}
	
	private JwtGenerator() {
		super();
	}

}

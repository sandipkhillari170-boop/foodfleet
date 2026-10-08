package com.example.FoodFleet.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
    @Value("${jwt.secret}" )  // fetch from Application,properties
    private String secret;           // store in this String

    private Key getSignInKey(){    // method
        byte[] keyBytes = Decoders.BASE64.decode(secret);    // convert in bytes
        return Keys.hmacShaKeyFor(keyBytes);     // convet bytes in cryptography signing key
    }

    public String generateToken(String username){
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() +1000 *60 *30))
                .signWith(getSignInKey())   //for verify and sing JWT to need a Cryptographic key
                .compact();      // jwt ko final String Token me Convert karta he

    }
    public String extractUsername(String token){
        return Jwts.parser()
                .verifyWith((SecretKey) getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}

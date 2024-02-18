package cl.camiletti.desafio.util;

import cl.camiletti.desafio.model.UserModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Date;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenUtil {
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 300000; // 5 minutos en milisegundos

    public String generateToken(UserModel user) throws JwtException {
        try {
            // Genera una clave secreta dinámica
            String secretKey = generateSecretKey();

            Algorithm algorithm = Algorithm.HMAC256(secretKey);

            // Construye el token JWT con la información del usuario
            return JWT.create()
                    .withSubject(user.getEmail())
                    .withClaim("id", Collections.singletonList(user.getId()))
                    .withClaim("created", new Date())
                    .withClaim("modified", new Date())
                    .withClaim("last_login", new Date())
                    .withClaim("isactive", true)
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .sign(algorithm);
        } catch (Exception e) {
            throw new JwtException("Error al generar el token JWT", e);
        }
    }

    private String generateSecretKey() {
        // Genera una clave secreta de 256 bits (32 bytes) utilizando SecureRandom
        byte[] keyBytes = new byte[32];
        new SecureRandom().nextBytes(keyBytes);
        return new String(keyBytes);
    }
}

package cl.camiletti.desafio.util;

import cl.camiletti.desafio.model.UserModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JwtTokenUtil  {
    private static final String SECRET_KEY = "m1Cl4v3_S3cr3t4_123!"; // Clave secreta para firmar el token
    private static final long EXPIRATION_TIME = 300000; // 5 minutos en milisegundos

    public String generateToken(UserModel user) {
        // Construye el token JWT con la información del usuario
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("id", user.getId())
                .claim("created", new Date())
                .claim("modified", new Date())
                .claim("last_login", new Date())
                .claim("isactive", true)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }


}

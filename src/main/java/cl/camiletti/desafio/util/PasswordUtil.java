package cl.camiletti.desafio.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtil {

    public static String encodePassword(String password) {
        return DigestUtils.sha256Hex(password);
    }

    public static boolean verifyPassword(String rawPassword, String encodedPassword) {
        return encodePassword(rawPassword).equals(encodedPassword);
    }
}

package cl.camiletti.desafio.util;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Validators {
    public boolean isValidEmail(String email) {
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }

    public boolean validatePassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();

        /*
        (?=.*[0-9]): Al menos un dígito.
        (?=.*[a-z]): Al menos una letra minúscula.
        (?=.*[A-Z]): Al menos una letra mayúscula.
        (?=.*[@#$%^&+=!]): Al menos un carácter especial de los especificados en la expresión.
        (?=\S+$): Sin espacios en blanco.
        .{8,}: Una longitud mínima de 8 caracteres.
        * * */
    }
}

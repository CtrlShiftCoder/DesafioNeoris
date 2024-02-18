package cl.camiletti.desafio.controller;

import cl.camiletti.desafio.model.UserModel;
import cl.camiletti.desafio.service.UserService;
import cl.camiletti.desafio.util.ErrorResponse;
import cl.camiletti.desafio.util.ValidationException;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Users")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody UserModel user) {
        try {
            UserModel registeredUser = userService.registerUser(user);
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } catch (ValidationException e) { // Captura la excepción de validación personalizada
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse("Error interno del servidor"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

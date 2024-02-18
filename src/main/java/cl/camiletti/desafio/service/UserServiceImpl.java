package cl.camiletti.desafio.service;

import cl.camiletti.desafio.model.PhoneModel;
import cl.camiletti.desafio.model.UserModel;
import cl.camiletti.desafio.repository.UserRepository;
import cl.camiletti.desafio.util.JwtTokenUtil;
import cl.camiletti.desafio.util.ValidationException;
import cl.camiletti.desafio.util.Validators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Validators validators;
    private final JwtTokenUtil jwtTokenUtil;

    private final PhoneServiceImpl phoneServiceImpl;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, Validators validators, JwtTokenUtil jwtTokenUtil,PhoneServiceImpl phoneServiceImpl) {
        this.userRepository = userRepository;
        this.validators = validators;
        this.jwtTokenUtil = jwtTokenUtil;
        this.phoneServiceImpl = phoneServiceImpl;

    }

    public UserModel registerUser(UserModel user) {
        try {
            if (!validators.isValidEmail(user.getEmail())) {
                throw new ValidationException("El correo electrónico no es válido");
            }

            if (!validators.validatePassword(user.getPassword())) {
                throw new ValidationException("La contraseña no cumple con los requisitos de seguridad");
            }

            if (userRepository.existsByEmail(user.getEmail())) {
                throw new ValidationException("El correo ya está registrado");
            }

            String token = jwtTokenUtil.generateToken(user);

            LocalDateTime currentDate = LocalDateTime.now();
            user.setCreated(currentDate);
            user.setModified(currentDate);
            user.setLastLogin(currentDate);

            UserModel savedUser = userRepository.save(user);

            for (PhoneModel phone : user.getPhones()) {
                phoneServiceImpl.savePhone(phone);
            }

            savedUser.setToken(token);
            return savedUser;
        } catch (ValidationException e) {
            throw new ValidationException("Error al registrar al usuario: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error interno al registrar al usuario", e);
        }
    }

}
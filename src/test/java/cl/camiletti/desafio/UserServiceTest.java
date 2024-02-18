package cl.camiletti.desafio;

import cl.camiletti.desafio.model.UserModel;
import cl.camiletti.desafio.repository.UserRepository;
import cl.camiletti.desafio.service.UserServiceImpl;
import cl.camiletti.desafio.util.JwtTokenUtil;
import cl.camiletti.desafio.util.ValidationException;
import cl.camiletti.desafio.util.Validators;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private Validators validators;

    @Mock
    private JwtTokenUtil jwtTokenUtil;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUser_Success() {
        UserModel user = new UserModel();
        user.setEmail("test@example.com");
        user.setPassword("password");

        when(validators.isValidEmail(user.getEmail())).thenReturn(true);
        when(validators.validatePassword(user.getPassword())).thenReturn(true);
        when(userRepository.existsByEmail(user.getEmail())).thenReturn(false);
        when(jwtTokenUtil.generateToken(user)).thenReturn("generatedToken");
        when(userRepository.save(user)).thenReturn(user);

        UserModel registeredUser = userService.registerUser(user);

        verify(validators).isValidEmail(user.getEmail());
        verify(validators).validatePassword(user.getPassword());
        verify(userRepository).existsByEmail(user.getEmail());
        verify(jwtTokenUtil).generateToken(user);
        verify(userRepository).save(user);

        assertNotNull(registeredUser);
        assertEquals(user, registeredUser);
        assertEquals("generatedToken", registeredUser.getToken());
    }

    @Test
    void testRegisterUser_InvalidEmail() {
        UserModel user = new UserModel();
        user.setEmail("invalidemail");
        user.setPassword("password");

        when(validators.isValidEmail(user.getEmail())).thenReturn(false);

        assertThrows(ValidationException.class, () -> userService.registerUser(user));

        verify(validators).isValidEmail(user.getEmail());
        verifyNoInteractions(userRepository, jwtTokenUtil);
    }

    @Test
    void testRegisterUser_InvalidPassword() {
        UserModel user = new UserModel();
        user.setEmail("test@example.com");
        user.setPassword("weak");

        when(validators.isValidEmail(user.getEmail())).thenReturn(true);
        when(validators.validatePassword(user.getPassword())).thenReturn(false);

        assertThrows(ValidationException.class, () -> userService.registerUser(user));

        verify(validators).isValidEmail(user.getEmail());
        verify(validators).validatePassword(user.getPassword());
        verifyNoInteractions(userRepository, jwtTokenUtil);
    }

    @Test
    void testRegisterUser_DuplicateEmail() {
        UserModel user = new UserModel();
        user.setEmail("test@example.com");
        user.setPassword("password");

        when(validators.isValidEmail(user.getEmail())).thenReturn(true);
        when(validators.validatePassword(user.getPassword())).thenReturn(true);
        when(userRepository.existsByEmail(user.getEmail())).thenReturn(true);

        assertThrows(ValidationException.class, () -> userService.registerUser(user));

        verify(validators).isValidEmail(user.getEmail());
        verify(validators).validatePassword(user.getPassword());
        verify(userRepository).existsByEmail(user.getEmail());
        verifyNoInteractions(jwtTokenUtil);
    }
}

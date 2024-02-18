package cl.camiletti.desafio;

import cl.camiletti.desafio.controller.UserController;
import cl.camiletti.desafio.model.UserModel;
import cl.camiletti.desafio.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUser_Success() {
        UserModel user = new UserModel();
        when(userService.registerUser(user)).thenReturn(user);
        ResponseEntity<Object> response = userController.registerUser(user);
        verify(userService).registerUser(user);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

}

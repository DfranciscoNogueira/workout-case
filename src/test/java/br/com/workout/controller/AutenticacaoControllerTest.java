package br.com.workout.controller;

import br.com.workout.config.JwtUtil;
import br.com.workout.dto.LoginDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AutenticacaoControllerTest {

    @Mock
    private JwtUtil jwtUtil;

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private AutenticacaoController autenticacaoController;

    @Test
    void deveAutenticarUsuarioComSucesso() {

        LoginDTO loginDTO = new LoginDTO("usuario", "senha123");

        Authentication authenticationMock = mock(Authentication.class);
        UserDetails userMock = mock(UserDetails.class);

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authenticationMock);
        when(authenticationMock.getPrincipal()).thenReturn(userMock);
        when(userMock.getUsername()).thenReturn("usuario");
        when(jwtUtil.generateToken("usuario")).thenReturn("mocked-jwt-token");

        ResponseEntity<?> resposta = autenticacaoController.authenticate(loginDTO);

        assertNotNull(resposta);
        assertEquals(200, resposta.getStatusCodeValue());
        assertTrue(resposta.getBody().toString().contains("mocked-jwt-token"));

        verify(authenticationManager, times(1)).authenticate(any(UsernamePasswordAuthenticationToken.class));
        verify(jwtUtil, times(1)).generateToken("usuario");

    }

}

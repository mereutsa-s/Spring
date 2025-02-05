package ru.geekbrain;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AuthServiceTests {

    @Mock
    private UserRepository userRepository;

    @Mock
    private SessionRepository sessionRepository;

    @InjectMocks
    private AuthService authService;

    private User testUser;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        testUser = new User("testuser", "password");
    }

    @Test
    public void testRegisterUser_CallsSaveOnUserRepository() {
        // Arrange
        when(userRepository.findByUsername("testuser")).thenReturn(null); // пользователь не существует

        // Act
        authService.register(testUser);

        // Assert
        verify(userRepository).save(testUser); // Проверяем, что метод save был вызван
    }

    @Test
    public void testLogin_CreatesSessionForExistingUser() {
        // Arrange
        when(userRepository.findByUsername("testuser")).thenReturn(testUser);

        // Act
        authService.login("testuser", "password");

        // Assert
        verify(sessionRepository).createSession(testUser); // Проверяем, что сессия была создана
    }

    @Test
    public void testLogout_EndsSessionForUser() {
        // Arrange
        Long testUserId = 1L;
        when(sessionRepository.getSessionByUserId(testUserId)).thenReturn(new Session(testUserId));

        // Act
        authService.logout(testUserId);

        // Assert
        verify(sessionRepository).endSession(testUserId); // Проверяем, что сессия была завершена
    }
}
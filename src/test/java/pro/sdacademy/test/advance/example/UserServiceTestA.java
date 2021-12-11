package pro.sdacademy.test.advance.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sdacademy.test.advance.example.a.User;
import pro.sdacademy.test.advance.example.a.UserRepository;
import pro.sdacademy.test.advance.example.a.UserService;
import pro.sdacademy.test.advance.example.a.UserValidator;

;

@ExtendWith(MockitoExtension.class)
public class UserServiceTestA {

  private static final long IDENTIFIER = 1L;
  private static final User USER = new User(IDENTIFIER, "Alice", "Cat");

  @Mock
  private UserRepository userRepository;

  @Mock
  private UserValidator userValidator;

  // @InjectMocks creates an instance of the class and injects the mocks that are created with the @Mock
  @InjectMocks
  private UserService userService;

  @Test
  void shouldGetUserById() {
    when(userRepository.findById(IDENTIFIER)).thenReturn(Optional.of(USER));

    final User actualUser = userService.getUserById(IDENTIFIER);

    assertThat(actualUser).isEqualTo(USER);
    verify(userRepository).findById(IDENTIFIER);
    verifyNoInteractions(userValidator);
  }

  @Test
  void shouldThrowWhenUserDoesNotExist() {
    when(userRepository.findById(IDENTIFIER)).thenReturn(Optional.empty());

    assertThatExceptionOfType(NoSuchElementException.class)
        .isThrownBy(() -> userService.getUserById(IDENTIFIER));

    verify(userRepository).findById(IDENTIFIER);
    verifyNoInteractions(userValidator);
    verifyNoMoreInteractions(userRepository);
  }

  @Test
  void shouldCreateUser() {
    when(userValidator.isUserValid(USER)).thenReturn(true);
    when(userRepository.addUser(USER)).thenReturn(USER);

    final User actualUser = userService.createUser(USER);

    assertThat(actualUser).isEqualTo(USER);
    verify(userRepository).addUser(USER);
    verify(userValidator).isUserValid(USER);
    verifyNoMoreInteractions(userRepository);
    verifyNoMoreInteractions(userValidator);
  }
}
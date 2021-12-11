import org.junit.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    private static final long IDENTIFIER = 1L;
    private static final User USER = new User(IDENTIFIER, "Alice", "Jones");

    @Mock
    private UserRepository userRepository;

    @Mock UserValidator userValidator;

    @Mock
    private Validator validator;

    @InjectMocks
    private UserService userService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldGetUserById(){
        //Arrange
        when(userRepository.findById(IDENTIFIER)).thenReturn(Optional.of(USER));

        //Act
        final User actualUser = userService.getUserById(IDENTIFIER);

        //Assert
        assertThat(actualUser).isEqualTo(USER);
        verify(userRepository).findById(IDENTIFIER);
        verifyZeroInteractions(validator);
    }

    @Test
    public void shouldCreateUser(){
        when(validator.isUserValid(USER)).thenReturn(true);
        when(userRepository.addUser(USER)).thenReturn(USER);

        final User actualUser = userService.createUser(USER);

        assertThat(actualUser).isEqualTo(USER);
        verify(validator).isUserValid(USER);
    }

    @Test
    public void shouldThrowExceptionWhenUserDoesNotExist(){
        when(userRepository.findById(IDENTIFIER)).thenReturn(Optional.empty());

        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> userService.getUserById(IDENTIFIER));

        verify(userRepository).findById(IDENTIFIER);
        verifyZeroInteractions(validator);
    }

    @Test
    public void shouldJustShowHowToMockMethodWithArgument(){
        final User userA = new User(1L, "Andrew", "");
        final User userB = new User(2L, "George", "Johnson");

        boolean test = validator.isUserValid(userA);

        when(userValidator.isValidUser(userA)).thenReturn(true);
        when(userValidator.isValidUser(userB)).thenReturn(false);

        System.out.println(validator.isUserValid(userA));
        System.out.println(validator.isUserValid(userB));
        System.out.println(validator.isUserValid(new User()));
    }
}

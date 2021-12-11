package pro.sdacademy.test.fundamentals.junit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import pro.sdacademy.test.fundamentals.junit.NameVerifier;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * @since
 */
class NameVerifierATest {

  @Test
  void shouldValidateName() {
    String name = "Adam";
    NameVerifier nameVerifier = new NameVerifier();

    final boolean validationResult = nameVerifier.isNameValid(name);

    assertTrue(validationResult);
  }

  @Test
  void shouldNotValidateNameWhenAllLettersAreLowerCase() {
    String name = "adam";
    NameVerifier nameVerifier = new NameVerifier();

    final boolean validationResult = nameVerifier.isNameValid(name);

    assertFalse(validationResult);
  }

  @Test
  void shouldNotValidateEmptyName() {
    String emptyName = "";
    NameVerifier nameVerifier = new NameVerifier();

    final boolean validationResult = nameVerifier.isNameValid(emptyName);

    assertFalse(validationResult);
  }

  @Test
  void shouldNotValidateNullName() {
    String nullName = null;
    NameVerifier nameVerifier = new NameVerifier();

    final boolean validationResult = nameVerifier.isNameValid(nullName);

    assertFalse(validationResult);
  }
}

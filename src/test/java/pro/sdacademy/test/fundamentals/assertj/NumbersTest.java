package pro.sdacademy.test.fundamentals.assertj;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.OptionalInt;
import org.junit.jupiter.api.Test;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * @since
 */
class NumbersTest {

  private Numbers numbers = new Numbers();

  @Test
  void shouldFindFirstDigitInString() {
    final OptionalInt firstDigit = numbers.findFirstDigit("Hello!!112");

    assertThat(firstDigit).isPresent()
        .hasValue(1);
  }

  @Test
  void shouldNotFindAnyDigitWhenThereAreNone() {
    final OptionalInt firstDigit = numbers.findFirstDigit("SDA");

    assertThat(firstDigit).isEmpty();
  }
}

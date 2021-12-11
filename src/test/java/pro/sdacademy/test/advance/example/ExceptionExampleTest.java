package pro.sdacademy.test.advance.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pro.sdacademy.test.advance.example.ExceptionExample.divide;

import org.junit.jupiter.api.Test;

public class ExceptionExampleTest {

  @Test
  void shouldThrowIllegalArgumentException() {
    final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> divide(10, 0));

    assertThat(exception).hasMessage("dividend can't be 0")
        .hasNoCause();
  }

  @Test
  void shouldThrowIllegalArgumentExceptionAssertJV1() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> divide(10, 0))
        .withMessage("dividend can't be 0")
        .withNoCause();
  }

  @Test
  void shouldThrowIllegalArgumentExceptionAssertJV2() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> divide(10, 0))
        .withMessage("dividend can't be 0")
        .withNoCause();
  }

  @Test
  void shouldThrowIllegalArgumentExceptionAssertJV3() {

    assertThatThrownBy(() -> divide(10, 0))
        .isExactlyInstanceOf(IllegalArgumentException.class)
        .hasMessage("dividend can't be 0")
        .hasNoCause();
  }

  @Test
  void shouldThrowNullPointerException() {

    String s = null;
    assertThatNullPointerException()
        .isThrownBy(() -> s.toLowerCase())
        .withNoCause();
  }
}

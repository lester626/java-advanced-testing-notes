package pro.sdacademy.test.fundamentals.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import pro.sdacademy.test.fundamentals.junit.Calculator;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * @since
 */
public class CalculatorTest {

  @Test
  void shouldAddTwoNumbers() {
    // given
    double valueA = 5.2;
    double valueB = 3.1;
    Calculator calculator = new Calculator();

    // when
    double actualResult = calculator.add(valueA, valueB);

    //then
    assertEquals(8.3, actualResult);
  }
}

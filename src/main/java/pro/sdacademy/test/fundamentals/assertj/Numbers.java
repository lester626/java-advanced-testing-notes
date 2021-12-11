package pro.sdacademy.test.fundamentals.assertj;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * @since
 */
import java.util.OptionalInt;

public class Numbers {

  public OptionalInt findFirstDigit(final String number) {
    return number.chars()
        .filter(Character::isDigit)
        .map(Character::getNumericValue)
        .findFirst();
  }
}

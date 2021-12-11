package pro.sdacademy.test.fundamentals.junit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * @since
 */
public class ListUtils {

  public List<Integer> multiplyInputs(final List<Integer> input, final int multiplier) {
    final List<Integer> results = new ArrayList<>();
    for (final Integer value : input) {
      results.add(value * multiplier);
    }
    return results;
  }
}

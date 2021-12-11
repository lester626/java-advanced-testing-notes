package pro.sdacademy.test.fundamentals.junit;


import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * @since
 */
public class StringUtils {

  public List<String> toUpperCase(final List<String> inputs) {
    return inputs.stream()
        .map(String::toUpperCase)
        .collect(Collectors.toUnmodifiableList());
  }

  public List<String> toLowerCase(final List<String> inputs) {
    return inputs.stream()
        .map(String::toLowerCase)
        .collect(Collectors.toUnmodifiableList());
  }

  public List<String> toSnakeCase(final List<String> inputs) {
    throw new UnsupportedOperationException("Not yet implemented");
  }
}
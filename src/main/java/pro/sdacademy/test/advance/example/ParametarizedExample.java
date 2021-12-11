package pro.sdacademy.test.advance.example;

import java.util.List;

public class ParametarizedExample {

  public static boolean isOdd(int number) {
    return number % 2 != 0;
  }

  public static String toUpperCase(String input) {
    return input.trim().toUpperCase();
  }

  public static boolean isBlank(String input) {
    return input == null || input.trim().isEmpty();
  }

  public static boolean isValid(List<String> values) {
    return values != null && !values.isEmpty();
  }
}

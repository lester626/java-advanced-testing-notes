package pro.sdacademy.test.advance.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParametarizedExampleTest {

  @ParameterizedTest
  @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
  void shouldReturnTrueForOddNumbers(int number) {
    System.out.println(ParametarizedExample.isOdd(number));
    assertTrue(ParametarizedExample.isOdd(number));
  }

  @ParameterizedTest
  @ValueSource(doubles = {1, 2.3, 4.1})
  void shouldPassDoubleToParam(double param) {
    System.out.println(param);
  }

  @ParameterizedTest
  @ValueSource(strings = {"Ala", "has a", "cat"})
  void shouldPassStringToTest(String word) {
    System.out.println(word);
  }

  @ParameterizedTest
  @ValueSource(classes = {String.class, Integer.class, Double.class})
  void shouldPassClassTypeAsParam(Class<?> clazz) {
    System.out.println(clazz);
  }

  @ParameterizedTest
  @EnumSource(TemperatureConverter.class)
  void shouldConvertToValueHigherThanMinInteger(TemperatureConverter converter) {
    float result = converter.convertTemp(10);
    System.out.println(converter + "=" + result);
    assertTrue(result > Integer.MIN_VALUE);
  }

  @ParameterizedTest
  @EnumSource(value = TemperatureConverter.class, names = {"CELSIUS_KELVIN", "CELSIUS_FAHRENHEIT"})
  void shouldConvertToTemperatureLowerThanMaxInteger(TemperatureConverter converter) {
    assertTrue(converter.convertTemp(10) < Integer.MAX_VALUE);
  }

  @ParameterizedTest
  @EnumSource(value = TemperatureConverter.class,
      names = {"KELVIN_CELSIUS"},
      mode = EnumSource.Mode.EXCLUDE)
  void shouldConvertTemperatureToPositiveValue(TemperatureConverter converter) {
    assertTrue(converter.convertTemp(10) > 0); // the test will run for the values CELSIUS KELVIN and CELSIUS FAHRENHEIT
  }

  @ParameterizedTest
  @CsvSource({"  test  ,TEST", "tEst ,TEST", "   Java,JAVA"})
  void shouldTrimAndUppercaseInputV1(String input, String expected) {
    System.out.println(input + ":" + expected);
    String actualValue = ParametarizedExample.toUpperCase(input);
    assertEquals(expected, actualValue);
  }

  @ParameterizedTest
  @CsvSource(value = {"  test  ;TEST", "tEst ;TEST", "   Java;JAVA"}, delimiter = ';')
  void shouldTrimAndUppercaseInputV2(String input, String expected) {
    System.out.println(input + ":" + expected);
    String actualValue = ParametarizedExample.toUpperCase(input);
    assertEquals(expected, actualValue);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/data.csv", numLinesToSkip = 2)
    // the data.csv file must be in the classpath root, we skip the first line in the file
  void shouldUppercaseAndBeEqualToExpected(String input, String expected) {

    System.out.println(input + ":" + expected);
    String actualValue = ParametarizedExample.toUpperCase(input);
    assertEquals(expected, actualValue);
  }

  @ParameterizedTest
  @MethodSource("provideNumbers")
  void shouldBeOdd(final Integer number) {
    assertThat(number % 2).isEqualTo(1);
  }

  static Stream<Integer> provideNumbers() {
    return Stream.of(1, 13, 101, 11, 121);
  }

  @ParameterizedTest
  @MethodSource("provideNumbersWithInfoAboutParity")
  void shouldReturnExpectedValue(int number, boolean expected) {
    assertEquals(expected, number % 2 == 1);
  }

  private static Stream<Arguments> provideNumbersWithInfoAboutParity() {
    return Stream.of(Arguments.of(1, true),
        Arguments.of(2, false),
        Arguments.of(10, false),
        Arguments.of(11, true));
  }

  @ParameterizedTest
  @ArgumentsSource(NumberWithParityArgumentsProvider.class)
  void shouldReturnExpectedValueV2(int number, boolean expectedResult) {
    assertEquals(expectedResult, number % 2 == 1);
  }

  @ParameterizedTest
  @CsvSource(value = "1, true")
  @MethodSource("provideNumbersWithInfoAboutParity")
  void shouldReturnExpectedValueV3(int number, boolean expected) {
    assertEquals(expected, number % 2 == 1);
  }

  @ParameterizedTest
  @NullSource
  void shouldbeBlankForNull(String input) {
    assertTrue(ParametarizedExample.isBlank(input));
  }

  @ParameterizedTest
  @EmptySource
  void shouldNotBeValid(List<String> input) {
    assertFalse(ParametarizedExample.isValid(input));
  }

  @ParameterizedTest
  @NullAndEmptySource
  void nullAndEmptyShouldBeBlank(String input) {
    assertTrue(ParametarizedExample.isBlank(input));
  }
}

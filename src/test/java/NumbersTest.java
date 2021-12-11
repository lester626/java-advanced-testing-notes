import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Month;
import java.time.MonthDay;
import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class NumbersTest {
    //ValueSource, EnumSource, CsvSource, ArgumentSource
    //MethodSource, CsvFileSource

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) //six numbers
    public void isOdd_ShouldReturnTrueForOddNumbers(int number){
        assertTrue(Numbers.isOdd(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10, 28, 128})
    public void isEven_ShouldReturnTrueForEvenNumbers(int number){
        assertTrue(Numbers.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Rudy", "has a", "macbook"})
    public void shouldReturnValidForStrings(String word){
        assertTrue(word instanceof String);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    public void isDigit_ShouldReturnTrueForDigits(String input){
        assertTrue(Numbers.isADigit(input));
    }

    @ParameterizedTest
    @EnumSource(Numbers.TemperatureConverter.class)
    public void shouldConvertToValueHigherThanMinInteger(Numbers.TemperatureConverter converter){
        assertTrue(converter.convertTemp(10) > Integer.MIN_VALUE);
    }

    @ParameterizedTest
    @EnumSource(Month.class) //passing all 12 months
    public void getValueForAMonth_IsAlwaysBetweenOneAndTwelve(Month month){
        int monthNumber = month.getValue();
        assertTrue(monthNumber >= 1 && monthNumber <= 12);
    }

    @ParameterizedTest
    @EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
    public void someMonths_AreThirtyDaysLong(Month month){
        final boolean isALeapYear = false;
        assertEquals(30, month.length(isALeapYear));
    }

    @ParameterizedTest
    @EnumSource(value = Month.class, names = ".+BER", mode = EnumSource.Mode.MATCH_ANY)
    public void fourMonths_EndWithBER(Month month){
        EnumSet<Month> months = EnumSet.of(
                Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER);
        assertTrue(months.contains(month));
    }

    @ParameterizedTest
    @CsvSource({"karen, KAREN", "rudy, RUDY", "lawrence, LAWRENCE", "vincent, VINCENT"})
    public void toUpperCase_ShouldGenerateTheExpectedUpperCaseValue(String input, String expected){
        String actualValue = input.toUpperCase();
        assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @CsvSource(value = {"karen:KAREN", "rudy:RUDY", "lawrence:LAWRENCE", "vincent:VINCENT"}, delimiter = ':')
    public void toUpperCase2_ShouldGenerateTheExpectedUpperCaseValue(String input, String expected){
        String actualValue = input.toUpperCase();
        assertEquals(expected, actualValue);
    }
}

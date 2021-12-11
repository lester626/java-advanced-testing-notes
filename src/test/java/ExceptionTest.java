import org.junit.Test;
import org.assertj.core.api.Assertions;
import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.CoreMatchers.is;

public class ExceptionTest {
    @Test
    public void inputEmpty_ShouldThrowIllegalArgumentException(){
        try{
            Numbers.findFirstDigit("");
            Assertions.fail("Exception was not thrown");
        }catch (final IllegalArgumentException exp) {
            assertEquals("input cannot be empty", exp.getMessage());
        }
    }

    @Test
    public void inputEmpty_shouldThrowExceptionType(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Numbers.findFirstDigit(""))
                .withMessage("input cannot be empty")
                .withNoCause();
    }

    //assertThrows
    @Test
    public void cannotDivide_ShouldThrowIllegalArgumentException(){
        final IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> Numbers.divide(10, 0));
        assertThat(exception.getMessage(), is("dividend can't be 0"));
    }

    //assertThatExceptionType
    //isThrownBy, withMessage, withNoCause
    @Test
    public void cannotDivide_ShouldThrowExceptionType(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Numbers.divide(10, 0))
                .withMessage("dividend can't be 0")
                .withNoCause();
    }

    //assertThatThrownBy
    @Test
    public void cannotDivide_AssertEWhichException(){
        assertThatThrownBy(() -> Numbers.divide(10,0))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("dividend can't be 0")
                .hasNoCause();
    }
}

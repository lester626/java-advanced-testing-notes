package pro.sdacademy.test.fundamentals.junit;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * @since
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
  private String prefix;
  private String firstName;
  private String lastName;
}

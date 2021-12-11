package pro.sdacademy.test.fundamentals.assertj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * @since
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
  private String prefix;
  private String firstName;
  private String lastName;
}

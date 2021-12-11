package pro.sdacademy.test.fundamentals.junit;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * @since
 */
public class NameVerifier {

  public boolean isNameValid(final String name) {
    return name != null && name.length() > 0 && !name.toUpperCase().equals(name) && !name.toLowerCase().equals(name);
  }
}

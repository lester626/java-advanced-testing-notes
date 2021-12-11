package pro.sdacademy.test.fundamentals.junit;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * @since
 */
public class PersonFactory {

  public Person createPerson(final String firstName, final String lastName) {
    final String prefix = firstName.endsWith("a") ? "Ms" : "Mr";
    return new Person(prefix, firstName, lastName);
  }
}

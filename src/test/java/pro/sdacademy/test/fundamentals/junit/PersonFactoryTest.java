package pro.sdacademy.test.fundamentals.junit;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * @since
 */

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import pro.sdacademy.test.fundamentals.junit.Person;
import pro.sdacademy.test.fundamentals.junit.PersonFactory;

class PersonFactoryTest {

  private static final String MALE_NAME = "Adam";
  private static final String FEMALE_NAME = "Lisa";
  private static final String SURNAME = "Jobs";
  private static final String MALE_PREFIX = "Mr";
  private static final String FEMALE_PREFIX = "Ms";

  private final PersonFactory personFactory = new PersonFactory();

  @Test
  void shouldCreateMalePerson() {
    final Person person = personFactory.createPerson(MALE_NAME, SURNAME);

    assertAll(
        () -> assertEquals(SURNAME, person.getLastName()),
        () -> assertEquals(MALE_NAME, person.getFirstName()),
        () -> assertEquals(MALE_PREFIX, person.getPrefix())
    );
  }

  @Test
  void shouldCreateFemalePerson() {
    final Person person = personFactory.createPerson(FEMALE_NAME, SURNAME);

    assertAll(
        () -> assertEquals(SURNAME, person.getLastName()),
        () -> assertEquals(FEMALE_NAME, person.getFirstName()),
        () -> assertEquals(FEMALE_PREFIX, person.getPrefix())
    );
  }
}

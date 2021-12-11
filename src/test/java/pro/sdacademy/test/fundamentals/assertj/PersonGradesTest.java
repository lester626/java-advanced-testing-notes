package pro.sdacademy.test.fundamentals.assertj;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Test;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * @since
 */
class PersonGradesTest {

  private static final Person PERSON_A = new Person("Mr", "Tom", "Hill");
  private static final Person PERSON_B = new Person("Ms", "Elane", "Grant");


  private final PersonGrades personGrades = new PersonGrades();

  @Test
  public void shouldCreateFirstForPerson() {
    final int grade = 5;
    List<Integer> grades = personGrades.addGrade(PERSON_A, grade);

    assertThat(grades).containsExactly(grade);
  }

  @Test
  public void shouldAddGradeForExistingPerson() {
    final int gradeA = 5;
    final int gradeB = 4;
    personGrades.addGrade(PERSON_A, gradeA);

    List<Integer> grades = personGrades.addGrade(PERSON_A, gradeB);

    assertThat(grades)
        .hasSize(2)
        .contains(gradeA, gradeB);
  }

  @Test
  public void shouldClearAllGrades() {
    personGrades.addGrade(PERSON_A, 5);
    personGrades.addGrade(PERSON_B, 3);

    final Map<Person, List<Integer>> allGrades = personGrades.clearAllGrades();

    assertThat(allGrades).hasSize(2)
        .containsEntry(PERSON_A, List.of())
        .containsEntry(PERSON_B, List.of());
  }

  @Test
  public void shouldGetGradesForExistingPerson() {
    final int grade = 5;
    personGrades.addGrade(PERSON_A, grade);

    final Optional<List<Integer>> grades = personGrades.getPersonGrades(PERSON_A);

    assertThat(grades)
        .isPresent()
        .hasValue(List.of(grade));
  }

  @Test
  void shouldNotGetGradesForNonExistingPerson() {
    final Optional<List<Integer>> grades = this.personGrades.getPersonGrades(PERSON_B);

    assertThat(grades).isNotPresent();
  }
}

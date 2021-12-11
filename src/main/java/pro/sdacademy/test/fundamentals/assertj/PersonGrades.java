package pro.sdacademy.test.fundamentals.assertj;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * @since
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PersonGrades {

  private final Map<Person, List<Integer>> personToGrades = new HashMap<>();

  public List<Integer> addGrade(final Person person, final Integer grade) {
    if (personToGrades.containsKey(person)) {
      return personToGrades.computeIfPresent(person, (existingPerson, grades) -> {
        grades.add(grade);
        return grades;
      });
    }
    final List<Integer> grades = new ArrayList<>();
    grades.add(grade);
    personToGrades.put(person, grades);
    return grades;
  }

  public Optional<List<Integer>> getPersonGrades(final Person person) {
    if (personToGrades.containsKey(person)) {
      return Optional.of(personToGrades.get(person));
    }
    return Optional.empty();
  }

  public Map<Person, List<Integer>> clearAllGrades() {
    for (final var entry : personToGrades.entrySet()) {
      entry.getValue().clear();
    }
    return personToGrades;
  }
}

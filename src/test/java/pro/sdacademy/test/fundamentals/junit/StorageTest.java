package pro.sdacademy.test.fundamentals.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sdacademy.test.fundamentals.junit.Connection;
import pro.sdacademy.test.fundamentals.junit.Storage;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * @since
 */
class StorageTest {

  private static final String EXAMPLE_DATA = "Hello";

  private static Connection connection;
  private Storage storage;

  @BeforeAll
  static void setUpTestCase() throws InterruptedException {
    connection = new Connection();
    connection.open();
  }

  @AfterAll
  static void tearDownTestCase() throws InterruptedException {
    connection.close();
  }

  @BeforeEach
  void setUp() {
    storage = new Storage(connection);
  }

  @AfterEach
  void tearDown() {
    connection.refresh();
  }

  @Test
  void shouldAddDataToStorage() {
    final int result = storage.addValue(EXAMPLE_DATA);

    assertEquals(1, result);
    assertTrue(storage.getData().contains(EXAMPLE_DATA));
  }

  @Test
  void shouldRemoveExistingData() {
    storage.addValue(EXAMPLE_DATA);

    final boolean removeResult = storage.removeValue(EXAMPLE_DATA);

    assertTrue(removeResult);
  }

  @Test
  void shouldNotRemoveNonExistingData() {
    storage.addValue(EXAMPLE_DATA);

    final boolean removeResult = storage.removeValue("NotExistingData");

    assertFalse(removeResult);
    assertEquals(storage.getData().size(), 1);
  }

}

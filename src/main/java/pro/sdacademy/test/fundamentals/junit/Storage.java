package pro.sdacademy.test.fundamentals.junit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * @since
 */
public class Storage {

  private List<Object> data = new ArrayList<>();

  private final Connection connection;

  public Storage(Connection connection) {
    this.connection = connection;
  }

  // adds value to storage data and returns number of elements
  public int addValue(final Object value) {
    if (connection.isClosed()) {
      throw new StorageConnectionException("Connection is closed so data cannot be added");
    }
    data.add(value);
    return data.size();
  }

  // tries to remove value in storage. Returns true if value was removed, false otherwise.
  public boolean removeValue(final Object value) {
    if (connection.isClosed()) {
      throw new StorageConnectionException("Connection is closed so data cannot be removed");
    }
    return data.remove(value);
  }

  public List<Object> getData() {
    if (connection.isClosed()) {
      throw new StorageConnectionException("Connection is closed so data cannot be retrieved");
    }
    return data;
  }
}

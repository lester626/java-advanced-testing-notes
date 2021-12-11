package pro.sdacademy.test.fundamentals.junit;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * @since
 */
// not a real connection - just imitating slow connection
public class Connection {

  private boolean state;

  public void open() throws InterruptedException {
    Thread.sleep(500L); // I am a slow opening connection
    state = true;
  }

  public void close() throws InterruptedException {
    Thread.sleep(500L); // I am slow closing connection
    state = false;
  }

  public boolean isOpened() {
    return state;
  }

  public boolean isClosed() {
    return !isOpened();
  }

  public void refresh() {
    System.out.println("Refreshing the connection");
  }
}

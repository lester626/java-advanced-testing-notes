package pro.sdacademy.test.advance.example.b;

public interface DatabaseConnection {

  boolean isOpened();

  void open();

  boolean close();
}
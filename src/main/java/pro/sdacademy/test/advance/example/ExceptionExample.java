package pro.sdacademy.test.advance.example;

public class ExceptionExample {

  public static float divide(float a, float b) {
    if (b == 0) {
      throw new IllegalArgumentException("dividend can't be 0");
    }
    return a / b;
  }

  public void test() throws IllegalArgumentException {
    throw new IllegalArgumentException();
  }

  public static void main(String[] args) {
    new ExceptionExample();
  }

  public ExceptionExample() {
    try {
      test();

    } catch (IllegalArgumentException e) {
      System.out.println("illegal");
    }
  }
}

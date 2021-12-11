package pro.sdacademy.test.advance.example.d;

public interface MessageValidator {

  boolean isMessageRecipentReachable(final String recipentId);

  boolean isMessageValid(Message message);
}

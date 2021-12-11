package pro.sdacademy.test.advance.example.d;

import java.time.LocalDateTime;
import java.util.UUID;
import pro.sdacademy.test.advance.example.b.SdaException;

public class PrivateMessageSender {

  private final MessageSender messageSender;
  private final MessageValidator messageValidator;

  public PrivateMessageSender(final MessageSender messageSender, final MessageValidator messageValidator) {
    this.messageSender = messageSender;
    this.messageValidator = messageValidator;
  }

  public void sendPrivateMessage(final String text, final String authorId, final String recipentId) {
    final Message message = new Message(UUID.randomUUID(), text, LocalDateTime.now(), authorId, recipentId);
    if (!messageValidator.isMessageValid(message) || !messageValidator.isMessageRecipentReachable(recipentId)) {
      throw new SdaException("Cannot send a private message. Validation has failed");
    }

    messageSender.send(message, MessageType.PRIVATE);
  }
}

package pro.sdacademy.test.advance.example;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sdacademy.test.advance.example.b.SdaException;
import pro.sdacademy.test.advance.example.d.Message;
import pro.sdacademy.test.advance.example.d.MessageSender;
import pro.sdacademy.test.advance.example.d.MessageType;
import pro.sdacademy.test.advance.example.d.MessageValidator;
import pro.sdacademy.test.advance.example.d.PrivateMessageSender;

@ExtendWith(MockitoExtension.class)
public class PrivateMessageSenderTest {

  private static final String TEXT = "Hi Andrew";
  private static final String AUTHOR_ID = "Andrew";
  private static final String RECIPENT_ID = "Alice";

  @Mock
  private MessageSender messageSender;

  @Mock
  private MessageValidator messageValidator;

  @InjectMocks
  private PrivateMessageSender privateMessageSender;

  @Test
  void shouldSendPrivateMessage() {
    when(messageValidator.isMessageValid(any())).thenReturn(true);
    when(messageValidator.isMessageRecipentReachable(anyString())).thenReturn(true);
    doNothing().when(messageSender).send(any(Message.class), eq(MessageType.PRIVATE));

    privateMessageSender.sendPrivateMessage(TEXT, AUTHOR_ID, RECIPENT_ID);

    final InOrder inOrder = Mockito.inOrder(messageValidator);
    inOrder.verify(messageValidator).isMessageValid(any());
    inOrder.verify(messageValidator).isMessageRecipentReachable(anyString());
  }

  @Test
  void shouldThrowWhenRecipentIsInvalid() {
    when(messageValidator.isMessageValid(any())).thenReturn(true);
    when(messageValidator.isMessageRecipentReachable(anyString())).thenReturn(false);

    assertThatExceptionOfType(SdaException.class)
        .isThrownBy(() -> privateMessageSender.sendPrivateMessage(TEXT, AUTHOR_ID, RECIPENT_ID))
        .withNoCause();

    final InOrder inOrder = Mockito.inOrder(messageValidator);
    inOrder.verify(messageValidator).isMessageValid(any());
    inOrder.verify(messageValidator).isMessageRecipentReachable(anyString());
  }
}

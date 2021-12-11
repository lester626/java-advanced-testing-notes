package pro.sdacademy.test.advance.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sdacademy.test.advance.example.b.SdaException;
import pro.sdacademy.test.advance.example.d.Message;
import pro.sdacademy.test.advance.example.d.MessageSender;
import pro.sdacademy.test.advance.example.d.MessageType;
import pro.sdacademy.test.advance.example.d.MessageValidator;
import pro.sdacademy.test.advance.example.d.PrivateMessageSender;

@ExtendWith(MockitoExtension.class)
public class PrivateMessageSenderTestE {

  private static final String TEXT = "Hi Andrew";
  private static final String AUTHOR_ID = "Andrew";
  private static final String RECIPENT_ID = "Alice";

  @Mock
  private MessageSender messageSender;

  @Mock
  private MessageValidator messageValidator;

  @InjectMocks
  private PrivateMessageSender privateMessageSender;

  @Captor
  private ArgumentCaptor<Message> messageCaptor;

  @Test
  void shouldSendPrivateMessage() {
    when(messageValidator.isMessageValid(any())).thenReturn(true);
    when(messageValidator.isMessageRecipentReachable(anyString())).thenReturn(true);
    doNothing().when(messageSender).send(any(Message.class), eq(MessageType.PRIVATE));

    privateMessageSender.sendPrivateMessage(TEXT, AUTHOR_ID, RECIPENT_ID);

    verify(messageValidator).isMessageValid(messageCaptor.capture());
    verify(messageSender).send(messageCaptor.capture(), eq(MessageType.PRIVATE));

    final List<Message> allCapturedValues = messageCaptor.getAllValues();
    System.out.println(allCapturedValues);
    assertThat(new HashSet<>(allCapturedValues)).hasSize(1);
    assertMessageContainsExpectedFields(allCapturedValues.get(0));
  }

  private void assertMessageContainsExpectedFields(final Message message) {
    assertThat(message.getAuthor()).isEqualTo(AUTHOR_ID);
    assertThat(message.getRecipent()).isEqualTo(RECIPENT_ID);
    assertThat(message.getValue()).isEqualTo(TEXT);
    assertThat(message.getSendAt()).isNotNull();
    assertThat(message.getId()).isNotNull();
    assertThat(message.getSendAt()).isBefore(LocalDateTime.now());
  }

  @Test
  void shouldThrowWhenRecipentIsInvalid() {
    when(messageValidator.isMessageValid(any())).thenReturn(true);
    when(messageValidator.isMessageRecipentReachable(anyString())).thenReturn(false);

    assertThatExceptionOfType(SdaException.class)
        .isThrownBy(() -> privateMessageSender.sendPrivateMessage(TEXT, AUTHOR_ID, RECIPENT_ID))
        .withNoCause();

    verify(messageValidator).isMessageValid(messageCaptor.capture());
    assertMessageContainsExpectedFields(messageCaptor.getValue());
  }
}

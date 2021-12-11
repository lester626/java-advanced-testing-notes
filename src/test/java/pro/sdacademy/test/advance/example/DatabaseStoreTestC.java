package pro.sdacademy.test.advance.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sdacademy.test.advance.example.b.DatabaseConnection;
import pro.sdacademy.test.advance.example.b.DatabaseStore;

@ExtendWith(MockitoExtension.class)
class DatabaseStoreTestC {

  private static final String ELEMENT = "dbElement";

  @Mock(lenient = true)
  private DatabaseConnection databaseConnection;

  @InjectMocks
  private DatabaseStore databaseStore;

  @Test
  void shouldOpenDatabaseConnectionAndAddData() {
    //when(databaseConnection.isOpened()).thenReturn(false, true);
    doReturn(false, true).when(databaseConnection).isOpened();
    doNothing().when(databaseConnection).open();

    final int numberOfData = databaseStore.addData(ELEMENT);

    assertThat(numberOfData).isEqualTo(1);
    verify(databaseConnection, times(2)).isOpened();
    verify(databaseConnection).open();
    verifyNoMoreInteractions(databaseConnection);
  }
}

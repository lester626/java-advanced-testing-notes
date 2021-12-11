import org.junit.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DatabaseStoreTest {
    private static final String ELEMENT = "dbElement";

    @Mock()
    private DatabaseConnection databaseConnection;

    @InjectMocks
    private DatabaseStore databaseStore;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldAddDataForOpenedDatabaseConnection() throws SdaException{
        when(databaseConnection.isOpened()).thenReturn(true);

        final int numberOfData = databaseStore.addData(ELEMENT);

        assertThat(numberOfData).isEqualTo(1);
        //verify(databaseConnection).isOpened();
        //verify(databaseConnection, never()).open();
    }
}

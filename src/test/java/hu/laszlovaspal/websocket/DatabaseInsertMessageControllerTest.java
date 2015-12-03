package hu.laszlovaspal.websocket;

import hu.laszlovaspal.database.SimpleEntity;
import hu.laszlovaspal.database.SimpleEntityRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseInsertMessageControllerTest {

    @Mock
    private SimpleEntityRepository simpleEntityRepository;

    @InjectMocks
    private DatabaseInsertMessageController databaseInsertMessageController;

    @Before
    public void setup() {
        Mockito.doReturn(Mockito.mock(SimpleEntity.class))
                .when(simpleEntityRepository).save(Mockito.any(SimpleEntity.class));
    }

    @Test
    public void testProcessDatabaseInsertMessage() throws Exception {
        databaseInsertMessageController.processDatabaseInsertMessage(Mockito.mock(DatabaseInsertMessage.class));
        Mockito.verify(simpleEntityRepository).save(Mockito.any(SimpleEntity.class));
    }
}

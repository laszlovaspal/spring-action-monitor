package hu.laszlovaspal.websocket;

import hu.laszlovaspal.database.SimpleEntity;
import hu.laszlovaspal.database.SimpleEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class DatabaseInsertMessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseInsertMessageController.class);

    @Autowired
    private SimpleEntityRepository simpleEntityRepository;

    @MessageMapping("/insertIntoDatabase")
    public void processDatabaseInsertMessage(DatabaseInsertMessage databaseInsertMessage) {
        LOGGER.info("Inserting message into database: " + databaseInsertMessage.getData());
        simpleEntityRepository.save(new SimpleEntity(databaseInsertMessage.getData()));
    }

}

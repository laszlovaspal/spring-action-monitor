package hu.laszlovaspal.websocket;

import hu.laszlovaspal.database.SimpleEntity;
import hu.laszlovaspal.database.SimpleEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private SimpleEntityRepository simpleEntityRepository;

    @MessageMapping("/notify")
    public Message notifyClientOfDbChanges() {

        LOGGER.info("sending message through websocket");

        simpleEntityRepository.save(new SimpleEntity("cucc"));

        return new Message("asdf");
    }

}

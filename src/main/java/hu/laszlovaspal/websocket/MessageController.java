package hu.laszlovaspal.websocket;

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
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/notify")
    @SendTo("/topic/db")
    public Message notifyClientOfDbChanges() {

        LOGGER.info("sending message through websocket");

        for (int i = 0; i < 10; i++) {
            messagingTemplate.convertAndSend("/topic/db", new Message("cucc " + i));
        }

        return new Message("asdf");
    }

}

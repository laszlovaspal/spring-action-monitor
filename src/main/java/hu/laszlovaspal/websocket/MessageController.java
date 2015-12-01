package hu.laszlovaspal.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/notify")
    @SendTo("/topic/db")
    public Message notifyClientOfDbChanges() {

        for (int i = 0; i < 10; i++) {
            messagingTemplate.convertAndSend("/topic/db", new Message("cucc " + i));
        }

        return new Message("asdf");
    }

}

package hu.laszlovaspal.database;

import hu.laszlovaspal.websocket.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
public class SimpleEntity {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleEntity.class);

    @Transient
    private static SimpMessagingTemplate messagingTemplate;

    @Id
    @GeneratedValue
    private long id;

    private String data;

    public SimpleEntity() {
    }

    public SimpleEntity(String data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Autowired
    public void setMessagingTemplate(SimpMessagingTemplate messagingTemplate) {
        SimpleEntity.messagingTemplate = messagingTemplate;
    }

    @PostPersist
    public void notifyClientsOfInsert() {
        LOGGER.info("Notifying clients of db insert");
        messagingTemplate.convertAndSend("/topic/db", new Message("row inserted with data: " + data));
    }

    @PostUpdate
    public void notifyClientsOfUpdate() {
        LOGGER.info("Notifying clients of db update");
        messagingTemplate.convertAndSend("/topic/db", new Message("row updated with data: " + data));
    }

}

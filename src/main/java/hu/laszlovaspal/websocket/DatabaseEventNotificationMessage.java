package hu.laszlovaspal.websocket;

public class DatabaseEventNotificationMessage {

    private String messageContent;

    public DatabaseEventNotificationMessage() {
    }

    public DatabaseEventNotificationMessage(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageContent() {
        return messageContent;
    }
}

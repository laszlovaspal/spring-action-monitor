package hu.laszlovaspal.websocket;

public class DatabaseInsertMessage {

    private String data;

    public DatabaseInsertMessage() {
    }

    public DatabaseInsertMessage(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}

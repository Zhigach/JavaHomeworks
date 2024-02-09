package homework.commons;

import homework.client.Client;

import java.util.List;

public class Message {
    String payload;
    Client sender;
    List<Client> recepientList;

    public Message(String payload, Client sender, List<Client> recepientList) {
        this.payload = payload;
        this.sender = sender;
        this.recepientList = recepientList;
    }

    public Message(String payload) {
        this.payload = payload;
    }

    public Message(String payload, Client sender) {
        this.payload = payload;
        this.sender = sender;
    }

    @Override
    public String toString() {
        String user = sender != null ? sender.getUsername() + ":" : "";
        return String.format("%s %s", user, payload);
    }

    public String getPayload() {
        return payload;
    }

    public Client getSender() {
        return sender;
    }

    public List<Client> getRecepientList() {
        return recepientList;
    }
}

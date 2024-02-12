package homework.commons;

import homework.client.Client;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class Message {
    String payload;
    Client sender;
    List<Client> recepientList;

    public Message(Client sender, String payload, List<Client> recepientList) {
        this.payload = payload;
        this.sender = sender;
        this.recepientList = recepientList;
    }

    public Message(String payload) {
        this.payload = payload;
    }

    public Message(Client sender, String payload) {
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

    public static String fold(Message message) {
        JSONObject jsonObject = new JSONObject()
                .accumulate("client", message.getSender().getUsername())
                .accumulate("payload", message.getPayload())
                .accumulate("recipients", new JSONArray(message.getRecepientList()));
        return jsonObject.toString();
    }

    public static Message unfold(String lineMessage) {
        JSONObject jsonObject = new JSONObject(lineMessage);
        return new Message(
                new Client(jsonObject.getString("client")),
                jsonObject.getString("payload")
        );
    }
}

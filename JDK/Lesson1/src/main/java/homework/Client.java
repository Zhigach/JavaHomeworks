package homework;

import java.util.List;

public class Client implements MessageServerListener, ListenableMessageServer{
    private MessageServerListener listener;
    private Server server;
    private String username;
    private String password;
    private String ipAddress;
    private String networkPort;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUsername() {
        return username;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    Client(String username) {
        this.username = username;
    }

    boolean connectToServer(Server server) {
        if (server.connectClient(this)) {
            this.server = server;
            server.addListener(this);
            listener.messageReceived("Connected to server.", null, null);
            listener.messageReceived("Loading chat history....", null, null);
            for (String s : server.getChatHistory()) {
                listener.messageReceived(s, null, null);
            }
            listener.messageReceived("\n---New messages---", null, null);
            return true;
        } else {
            messageReceived("Connection refused.", this, null);
            return false;
        }
    }

    void sendMessage(String message, List<Client> clientList) {
        if (!server.sendMessageRequest(message, this, clientList)) {
            listener.messageReceived("Messaging is unavailable.", new Client("Server"), null);
        }
    }

    @Override
    public void addListener(MessageServerListener listener) {
        this.listener = listener;
    }

    @Override
    public void messageReceived(String message, Client from, List<Client> recepientList) {
        // filtration of recepients: && recepientList.stream().map(x -> getUsername().equals(username)).findAny().isPresent()) {
        listener.messageReceived(message, from, recepientList);
    }
}

package homework.client;

import homework.commons.Message;
import homework.server.Server;
import homework.views.ClientGUI;

import java.util.List;

public class Client implements MessageServerListener {
    private ClientView clientView;
    private Server server; // TODO use socket
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

    public Client(String username) {
        this.username = username;
    }

    public void connectToServer(Server server) {
        if (server.connectClient(this)) {
            this.server = server;
            server.addListener(this);
            clientView.showMessage(new Message("Connected to server."));
            clientView.showMessage(new Message("Loading chat history...."));
            for (String s : server.getChatHistory()) {
                clientView.showMessage(new Message(s));
            }
            clientView.showMessage(new Message("\n---New messages---"));
            setConnectionStatus(true);
        } else {
            messageReceived(new Message("Connection refused."));
        }
    }

    public void sendMessage(String message, List<Client> clientList) {
        if (server.clientMessageReceived(new Message(message, this, clientList)) == false) {
            clientView.showMessage(new Message("Messaging is unavailable."));
        }
    }


    @Override
    public void messageReceived(Message message) {
        // filtration of recepients: && recepientList.stream().map(x -> getUsername().equals(username)).findAny().isPresent()) {
        clientView.showMessage(message);
    }

    @Override
    public void setConnectionStatus(boolean state) {
        clientView.setConnected(state);
    }
    public void setView(ClientGUI clientGUI) {
        this.clientView = clientGUI;
    }
}

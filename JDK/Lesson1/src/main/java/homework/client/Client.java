package homework.client;

import homework.commons.Message;
import homework.networks.ClientNet;
import homework.views.ClientGUI;

import java.util.List;

public class Client implements MessageServerListener {
    private boolean isConnected = false;
    private final ClientNetworking networkingAdapter;
    private ClientView clientView;
    private String username;
    private String password;
    private String ipAddress;
    private String networkPort;

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    @Override
    public String getUsername() {
        return username;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Client(String username) {
        this.networkingAdapter = new ClientNet(this);
        this.username = username;
    }

    public void connectToServer(String ip, int port) {
        if (networkingAdapter.startConnection(ip, port)) {
            clientView.showMessage(new Message("Connected to server."));
            setConnectionStatus(true);
        } else {
            clientView.showMessage(new Message("Connected refused."));
        }
    }

    public void sendMessage(String message, List<Client> clientList, boolean isTechnicalMessage) {
        if (isConnected) {
            networkingAdapter.sendMessage(Message.fold(new Message(this, message, clientList)));
            if (!isTechnicalMessage) {
                clientView.showMessage(new Message(new Client("Me"), message));
            }
        } else {
            clientView.showMessage(new Message("You're offline. Messaging is unavailable."));
        }
    }

    @Override
    public void messageReceived(Message message) {
        clientView.showMessage(message);
    }

    @Override
    public void disconnectFromServer() {
        if (isConnected) {
            sendMessage("]^ESCEnd session", null, true);
            setConnectionStatus(false);
            networkingAdapter.stopConnection();
        }
    }
    @Override
    public void setConnectionStatus(boolean state) {
        clientView.setConnected(state);
        isConnected = state;
    }
    public void setView(ClientGUI clientGUI) {
        this.clientView = clientGUI;
    }
}

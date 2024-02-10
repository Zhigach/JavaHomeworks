package homework.server;

import homework.client.MessageServerListener;
import homework.client.Client;
import homework.commons.Message;
import homework.networks.ServerNet;

import java.io.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Server implements ListenableMessageServer {
    private final ServerNetworking serverNetworkingAdapter;
    private final ServerView serverView;
    private final String LOG_FILE_NAME = "chatHistory.log";
    private final List<MessageServerListener> listeners = new ArrayList<>();
    private boolean CONNECTION_READY = false;
    private final int capacity;
    private final List<Client> clientList;

    public Server(ServerView serverView) {
        this.serverNetworkingAdapter = new ServerNet(this);
        this.serverView = serverView;
        clientList = new ArrayList<>();
        capacity = 10;
    }

    public boolean connectClient(Client client) {
        if (clientList.size() < capacity && isReady()) {
            messageReceived(new Message(new Client("Server"), String.format("%s connected", client.getUsername())));
            return clientList.add(client);
        } else {
            return false;
        }
    }

    public boolean startServer(int port) {
        serverNetworkingAdapter.startServer(port);
        CONNECTION_READY = true;
        return true;
    }

    public boolean stopServer() {

        messageReceived(new Message(new Client("Server"), "You've been disconnected from the server."));
        for (MessageServerListener listener : listeners) {
            listener.setConnectionStatus(false);
        }
        listeners.removeAll(listeners);

        serverNetworkingAdapter.stopServer();
        CONNECTION_READY = false;
        return true;
    }

    public boolean isReady() {
        return CONNECTION_READY;
    }

    public boolean clientMessageReceived(Message message) {
        if (isReady()) {
            messageReceived(message);
            return true;
        } else {
            return false;
        }
    }

    private void logMessage(Message message) {
        try (FileWriter fileWriter = new FileWriter(LOG_FILE_NAME, true)) {
            String modifiedMessage =
                    String.format("[%s] <%s>: %s\n", LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS),
                            message.getSender().getUsername(),
                            message.getPayload());
            fileWriter.append(modifiedMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void messageReceived(Message message) {
        notifyListeners(message);
        showMessageAtGUI(message);
        logMessage(message);
    }

    private void notifyListeners(Message message) {
        for (MessageServerListener listener : listeners) {
            listener.messageReceived(message);
        }
    }

    public List<String> getChatHistory() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(LOG_FILE_NAME))) {
            List<String> logContent = new ArrayList<>();
            while (fileReader.ready()) {
                logContent.add(fileReader.readLine());
            }
            return logContent;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showMessageAtGUI(Message message) {
        serverView.showMessage(message);
    }

    @Override
    public void addListener(MessageServerListener listner) {
        listeners.add(listner);
    }

}

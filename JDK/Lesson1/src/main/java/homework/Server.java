package homework;

import java.io.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Server implements ListenableMessageServer {
    private ServerGUI gui;
    private final String LOGFILENAME = "chatHistory.log";
    private List<MessageServerListener> listeners = new ArrayList<>();
    private boolean CONNECTION_READY = false;
    private final int capacity;
    private List<Client> clientList;

    Server() {
        clientList = new ArrayList<>();
        capacity = 10;
    }
    Server(int capacity) {
        this.capacity = capacity;
    }

    public boolean connectClient(Client client) {
        if (clientList.size() < capacity && isReady() ) {
            notifyListeners(String.format("%s connected", client.getUsername()), new Client("Server"), null);
            return clientList.add(client);
        } else {
            return false;
        }
    }

    public void setGui(ServerGUI gui) {
        this.gui = gui;
    }

    boolean startServer() {
        CONNECTION_READY = true;
        return true;
    }
    boolean stopServer() {
        CONNECTION_READY = false;
        notifyListeners("You've been disconnected from the server.", new Client("Server"), null);
        listeners.removeAll(listeners);
        return true;
    }

    boolean isReady() {
        return CONNECTION_READY;
    }

    public boolean sendMessageRequest(String message, Client sender, List<Client> recepientList) { // filtered at the client side
        if (isReady()) {
            notifyListeners(message, sender, recepientList);
            return true;
        } else {
            return false;
        }

    }

    private void logMessage(String message, Client sender) {
        try (FileWriter fileWriter = new FileWriter(LOGFILENAME,true)) {
            String modifiedMessage = String.format("[%s] <%s>: %s\n", LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), sender.getUsername(), message);
            fileWriter.append(modifiedMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void notifyListeners(String message, Client sender, List<Client> recepientList){
        for (MessageServerListener listener : listeners) {
            String modifiedMessage = String.format("%s: %s", sender.getUsername(), message);
            listener.messageReceived(modifiedMessage, sender, recepientList);
        }
        logMessage(message, sender);
    }

    List<String> getChatHistory() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(LOGFILENAME))) {
            List<String> logContent = new ArrayList<>();
            while (fileReader.ready()) {
                logContent.add(fileReader.readLine());
            }
            return logContent;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void addListener(MessageServerListener listner) {
        listeners.add(listner);
    }
}

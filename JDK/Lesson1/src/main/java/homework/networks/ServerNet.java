package homework.networks;

import homework.client.Client;
import homework.client.MessageServerListener;
import homework.commons.Message;
import homework.server.ListenableMessageServer;
import homework.server.Server;
import homework.server.ServerNetworking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServerNet implements ServerNetworking {
    private ServerSocket serverSocket;
    private final HashMap<String, PrintWriter> clientStreamMap = new HashMap<>();
    private final List<PrintWriter> outputStreams = new ArrayList<>();
    private final ListenableMessageServer server;
    public ServerNet(Server server) {
        this.server = server;
    }

    @Override
    public void startServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        startNewSocket();
    }

    void startNewSocket() {
        new SocketListenHandler().start();
    }


    @Override
    public void broadcastMessage(String message) {
        String senderUsername = Message.unfold(message).getSender().getUsername();
        for (PrintWriter outputStream : outputStreams) {
            if (!outputStream.equals(clientStreamMap.get(senderUsername)))
                outputStream.println(message);
        }
    }

    @Override
    public void stopServer() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getAddress() {
        return serverSocket.getLocalSocketAddress().toString();
    }

    @Override
    public String getPort() {
        return Integer.toString(serverSocket.getLocalPort());
    }

    private class SocketListenHandler extends Thread {
        private MessageServerListener client;
        public SocketListenHandler() {}

        void handShake(PrintWriter out, BufferedReader in) {
            try {
                client = new Client(requestUsername(out, in));
                server.connectClient(client);
                clientStreamMap.put(client.getUsername(), out);
                outputStreams.add(out);
                handoverChatHistory(out);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String requestUsername(PrintWriter out, BufferedReader in) throws IOException {
            out.println("]^WELCOME MSG");
            return in.readLine();
        }
        void handoverChatHistory(PrintWriter out) {
            for (String s : server.getChatHistory()) {
                out.println(s);
            }
            out.println("CHAT HISTORY END");
        }
        public void run() {
            try {
                Socket clientSocket = serverSocket.accept();
                startNewSocket(); // create new channel when the current one is taken

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                handShake(out, in);

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if (Message.unfold(inputLine).getPayload().equals("]^ESCEnd session")) {
                        outputStreams.remove(out);
                        server.clientMessageReceived(new Message(new Client("Server"), String.format("%s disconnected.", client.getUsername())));
                        break;
                    }
                    server.clientMessageReceived(Message.unfold(inputLine));
                }
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

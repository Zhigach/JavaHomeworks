package homework.networks;

import homework.client.Client;
import homework.client.ClientNetworking;
import homework.client.MessageServerListener;
import homework.commons.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientNet implements ClientNetworking {
    private MessageServerListener client;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientNet(Client client) {
        this.client = client;
    }

    public boolean startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            new ConnectionHandler(clientSocket).start();
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public String sendMessage(String message) {
        out.println(message);
        return null;//in.readLine(); probably some response here
    }

    public void stopConnection() {
        try {
            out.println("End session");
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private class ConnectionHandler extends Thread {
        private final Socket serverSocket;

        public ConnectionHandler(Socket socket) {
            this.serverSocket = socket;
        }

        void handShake() throws IOException {
            String input;
            while ((input = in.readLine()) != null ) {
                if (input.equals("]^WELCOME MSG")) {
                    out.println(client.getUsername());
                    break;
                }
            }
            while ( (input = in.readLine()) != null ) {
                if (input.equals("CHAT HISTORY END")) {
                    break;
                }
                client.messageReceived(new Message(input));
            }
        }
        @Override
        public void run() {
            try {
                out = new PrintWriter(serverSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));

                handShake();

                String inputLine;

                while ( (inputLine = in.readLine()) != null) {
                    client.messageReceived(Message.unfold(inputLine));
                    if (Message.unfold(inputLine).getPayload().equals("You've been disconnected from the server.") ) {
                        client.disconnectFromServer();
                        break;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

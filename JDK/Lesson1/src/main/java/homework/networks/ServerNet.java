package homework.networks;

import homework.commons.Message;
import homework.server.Server;
import homework.server.ServerNetworking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerNet implements ServerNetworking {
    private ServerSocket serverSocket;
    private Server server;

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
        while (true) {
            try {
                new SocketListenHandler(serverSocket.accept()).start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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

    private class SocketListenHandler extends Thread {
        private final Socket clientSocket;

        public SocketListenHandler(Socket socket) {
            this.clientSocket = socket;
        }
        public void run() {
            try {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    //TODO pass to server
                    server.clientMessageReceived(Message.unfold(inputLine));
                    if (inputLine.equals("End session"))
                        break;
                }
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

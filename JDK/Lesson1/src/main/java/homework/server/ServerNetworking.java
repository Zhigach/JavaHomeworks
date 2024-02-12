package homework.server;

public interface ServerNetworking {
    void startServer(int port);
    void broadcastMessage(String message);
    void stopServer();
    String getAddress();
    String getPort();
}

package homework.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public interface ClientNetworking {
     boolean startConnection(String ip, int port);
     String sendMessage(String message);
     void stopConnection();
}

package homework.server;

import homework.client.MessageServerListener;
import homework.commons.Message;

import java.util.List;

public interface ListenableMessageServer {
    boolean connectClient(MessageServerListener listner);

    boolean clientMessageReceived(Message message);

    List<String> getChatHistory();
}

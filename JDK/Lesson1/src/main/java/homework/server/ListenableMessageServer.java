package homework.server;

import homework.client.MessageServerListener;

public interface ListenableMessageServer {
    void addListener(MessageServerListener listner);
}

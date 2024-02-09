package homework.client;

import homework.commons.Message;

public interface MessageServerListener {
    void messageReceived(Message message);
    void setConnectionStatus(boolean state);
}

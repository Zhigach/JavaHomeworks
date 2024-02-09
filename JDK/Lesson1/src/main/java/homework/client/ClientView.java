package homework.client;

import homework.commons.Message;

public interface ClientView {
    void showMessage(Message message);
    void setConnected(boolean newState);
}

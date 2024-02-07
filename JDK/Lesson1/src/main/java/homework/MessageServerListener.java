package homework;

import java.util.List;

public interface MessageServerListener {
    public void messageReceived(String message, Client from, List<Client> recepientList);
}

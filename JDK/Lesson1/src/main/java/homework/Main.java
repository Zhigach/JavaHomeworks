package homework;

/*
  На семинаре мы работали с проектом https://github.com/Liberate520/jdk_server_lesson1/tree/master
Изменили клиентскую часть проекта с учетом интерфейсов и получили https://github.com/Liberate520/jdk_server_lesson2/tree/master
Задача исправить аналогичным образом серверную часть проекта, выделить интерфейсы. Можно работать со своим проектом
*Если вы уже это сделали в предыдущем дз, то можете просто повторно сдать работу, либо попробовать организовать связь через сокеты. В этом случае появятся доп классы
 */

import homework.views.ClientGUI;
import homework.server.Server;
import homework.views.ServerGUI;

public class Main {
    public static void main(String[] args) {

        ServerGUI serverGUI = new ServerGUI();

        ClientGUI clientGUI1 = new ClientGUI(serverGUI);
        ClientGUI clientGUI2 = new ClientGUI(serverGUI);
    }

}

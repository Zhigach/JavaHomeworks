package homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ServerGUI extends JFrame implements MessageServerListener {
    private static final int WINDOW_X_POS = 100;
    private static final int WINDOW_Y_POS = 100;
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 600;
    private static final String WINDOW_TITLE = "Server App";
    private final JTextArea textArea;
    private Server server;

    public Server getServer() {
        return server;
    }

    ServerGUI(Server server) {
        this.server = server;
        server.setGui(this);
        server.addListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_X_POS,WINDOW_Y_POS);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);

        setTitle(WINDOW_TITLE);
        setBackground(Color.RED);

        textArea = new JTextArea();

        JPanel buttonPanel = new JPanel(new GridLayout(1,2));
        JButton startBtn = getStartServerBtn(server);
        JButton stopBtn = new JButton("Stop server!");
        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (setAvailableStatus(false)) {
                    textArea.append("Server stopped.\n");
                } else {
                    textArea.append("Server already stopped.\n");
                }

            }
        });
        buttonPanel.add(startBtn);
        buttonPanel.add(stopBtn);
        buttonPanel.setSize(getWidth(), getHeight()/10);

        JPanel textPanel = new JPanel(new GridLayout(1, 1));
        JScrollPane scrollPane = new JScrollPane(textArea);
        textPanel.add(scrollPane);

        add(textPanel);
        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    private JButton getStartServerBtn(Server server) {
        JButton startBtn = new JButton("Start server");
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (setAvailableStatus(true)) {
                    textArea.append("Server started.\n");
                    textArea.append("Loading chat history....\n");
                    for (String s : server.getChatHistory()) {
                        textArea.append(s + "\n");
                    }
                    textArea.append("\n---New messages---\n");
                } else {
                    textArea.append("Server already started.\n");
                }
            }
        });
        return startBtn;
    }

    private boolean setAvailableStatus(boolean newStatus) {
        if (server.isReady() == newStatus) {
            return false;
        }
        if (newStatus) {
            startServer();
        } else {
            stopServer();
        }
        return true;
    }
    boolean startServer() {
        server.startServer();
        return true;
    }
    boolean stopServer() {
        server.stopServer();
        return true;
    }

    @Override
    public void messageReceived(String message, Client from, List<Client> recepientList) {
        textArea.append(message + "\n");
    }

}

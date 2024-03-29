package homework.views;

import homework.commons.Message;
import homework.server.Server;
import homework.server.ServerView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI extends JFrame implements ServerView {
    private static final int WINDOW_X_POS = 100;
    private static final int WINDOW_Y_POS = 100;
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 600;
    private static final String WINDOW_TITLE = "Server App";
    private final JTextArea textArea;
    private final Server server;

    public Server getServer() {
        return server;
    }

    public ServerGUI() {
        this.server = new Server(this);

        inintialSetUp();
        textArea = new JTextArea();
        setUpButtonPanel();
        setUpTextArea();

        setVisible(true);
    }

    private void inintialSetUp() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_X_POS,WINDOW_Y_POS);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle(WINDOW_TITLE);
    }

    void setUpButtonPanel() {
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

        add(buttonPanel, BorderLayout.SOUTH);
    }
    void setUpTextArea() {
        JPanel textPanel = new JPanel(new GridLayout(1, 1));
        JScrollPane scrollPane = new JScrollPane(textArea);
        textPanel.add(scrollPane);

        add(textPanel);
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
            setTitle(WINDOW_TITLE + String.format(" @ %s:%s",server.getAddress(), server.getPort()));
        } else {
            stopServer();
            setTitle(WINDOW_TITLE);
        }
        return true;
    }
    boolean startServer() {
        textArea.setText("");
        return server.startServer(5555);
    }
    boolean stopServer() {
        return server.stopServer();
    }


    @Override
    public void showMessage(Message message) {
        textArea.append(message.toString() + "\n");
    }
}

package homework.views;

import homework.client.Client;
import homework.client.ClientView;
import homework.commons.Message;
import homework.server.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame implements ClientView {
    private static final int WINDOW_X_POS = 100;
    private static final int WINDOW_Y_POS = 100;
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 600;
    private static final String WINDOW_TITLE = "Client App";
    private final JTextArea textArea;
    private final Server server;
    private Client client;
    private JButton sendButton;
    private JTextField messageField;
    private JButton loginButton;
    private JTextField loginField;

    public ClientGUI(ServerGUI serverGUI) {
        this.server = serverGUI.getServer();
        setLocationRelativeTo(serverGUI);

        initialSetUp();
        textArea = new JTextArea();
        setUpLoginPanel();
        setUpSendMessagePanel();
        getRootPane().setDefaultButton(loginButton);
        loginButton.requestFocus();
        setVisible(true);
    }


    private void initialSetUp() {
        setLocation(WINDOW_X_POS, WINDOW_Y_POS);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setTitle(WINDOW_TITLE);
        setBackground(Color.RED);
    }

    private void setUpLoginPanel() {
        JPanel loginPanel = new JPanel(new GridLayout(2, 3));
        JTextField addressField = new JTextField("8.8.8.8");
        JTextField portField = new JTextField("443");
        JTextField loginField = new JTextField("stranger");
        JTextField passwordField = new JTextField("******");

        loginButton = getLoginButton(loginField);

        loginPanel.add(addressField);
        loginPanel.add(portField);
        loginPanel.add(new JLabel("- - - -"));
        loginPanel.add(loginField);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        add(loginPanel, BorderLayout.NORTH);
    }

    private JButton getLoginButton(JTextField loginField) {
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client = new Client(loginField.getText());
                client.setView(ClientGUI.this);
                client.connectToServer(server);
            }
        });
        return loginButton;
    }

    private JButton getSendButton() {
        JButton sendButton = new JButton("SEND");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.sendMessage(messageField.getText(), null);
                messageField.setText("");
            }
        });
        sendButton.setEnabled(false);
        return sendButton;
    }

    private void setUpSendMessagePanel() {
        JPanel sendMessagePanel = new JPanel(new GridLayout(1, 2));

        messageField = new JTextField();
        sendButton = getSendButton();

        sendMessagePanel.add(messageField);
        sendMessagePanel.add(sendButton);

        JPanel textPanel = new JPanel(new GridLayout(1, 1));
        JScrollPane scrollPane = new JScrollPane(textArea);
        textPanel.add(scrollPane);

        add(sendMessagePanel, BorderLayout.SOUTH);
        add(textPanel);
    }

    @Override
    public void showMessage(Message message) {
        textArea.append(message + "\n");
    }

    @Override
    public void setConnected(boolean newState) {
        if (newState) {
            sendButton.setEnabled(true);
            setTitle(WINDOW_TITLE + " (Online)");
            getRootPane().setDefaultButton(sendButton);
            sendButton.requestFocus();
            loginButton.setVisible(false);
        } else {
            setTitle(WINDOW_TITLE + " (Offline)");
            sendButton.setEnabled(false);
            loginButton.setVisible(true);
        }
    }
}

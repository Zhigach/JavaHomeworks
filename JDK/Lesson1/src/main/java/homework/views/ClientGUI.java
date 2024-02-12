package homework.views;

import homework.client.Client;
import homework.client.ClientView;
import homework.commons.Message;

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
    private JTextField addressField;
    private JTextField portField;
    private Client client;
    private JButton sendButton;
    private JTextField messageField;
    private JButton loginButton;

    public ClientGUI(ServerGUI serverGUI) {
        setLocationRelativeTo(serverGUI);

        initialSetUp();
        textArea = new JTextArea();
        setUpLoginPanel();
        setUpSendMessagePanel();
        getRootPane().setDefaultButton(loginButton);
        loginButton.requestFocus();
        setVisible(true);
    }

    @Override
    public void dispose() {
        if (client != null) {
            client.disconnectFromServer();
        }
        super.dispose();
    }

    private void initialSetUp() {
        setLocation(WINDOW_X_POS, WINDOW_Y_POS);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setTitle(WINDOW_TITLE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void setUpLoginPanel() {
        JPanel loginPanel = new JPanel(new GridLayout(2, 3));
        addressField = new JTextField("127.0.0.1");
        portField = new JTextField("5555");
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
                client.connectToServer(addressField.getText(), Integer.parseInt(portField.getText()));
                client.setIpAddress(addressField.getText());
            }
        });
        return loginButton;
    }

    private JButton getSendButton() {
        JButton sendButton = new JButton("SEND");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.sendMessage(messageField.getText(), null, false);
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

    private String getAddress() {
        return addressField.getText();
    }
    private int getPort() {
        return Integer.parseInt(portField.getText());
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

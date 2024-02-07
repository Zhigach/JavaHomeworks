package homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClientGUI extends JFrame implements MessageServerListener{
    private static final int WINDOW_X_POS = 100;
    private static final int WINDOW_Y_POS = 100;
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 600;
    private static final String WINDOW_TITLE = "Client App";
    private final JTextArea textArea;

    private Server server;

    private Client client;

    private JButton sendButton;

    ClientGUI(ServerGUI serverGUI) {
        setLocationRelativeTo(serverGUI);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_X_POS,WINDOW_Y_POS);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);

        setTitle(WINDOW_TITLE);
        setBackground(Color.RED);

        textArea = new JTextArea();

        JPanel loginPanel = new JPanel(new GridLayout(2,3));
        JTextField addressField = new JTextField("8.8.8.8");
        JTextField portField = new JTextField("443");
        JTextField loginField = new JTextField("stranger");
        JTextField passwordField = new JTextField("******");

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client = new Client(loginField.getText());
                client.addListener(ClientGUI.this);
                if (client.connectToServer(serverGUI.getServer())) {
                    getRootPane().setDefaultButton(sendButton);
                    sendButton.requestFocus();
                    loginButton.setVisible(false);
                    //remove(loginPanel);
                }
            }
        });

        loginPanel.add(addressField);
        loginPanel.add(portField);
        loginPanel.add(new JLabel("- - - -"));
        loginPanel.add(loginField);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);


        JPanel sendMessagePanel = new JPanel(new GridLayout(1,2));
        JTextField messageField = new JTextField();
        sendButton = new JButton("SEND");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.sendMessage(messageField.getText(), null);
                messageField.setText("");
            }
        });

        sendMessagePanel.add(messageField);
        sendMessagePanel.add(sendButton);

        JPanel textPanel = new JPanel(new GridLayout(1, 1));
        JScrollPane scrollPane = new JScrollPane(textArea);
        textPanel.add(scrollPane);

        add(loginPanel, BorderLayout.NORTH);
        add(sendMessagePanel, BorderLayout.SOUTH);
        add(textPanel);

        getRootPane().setDefaultButton(loginButton);
        loginButton.requestFocus();

        setVisible(true);

    }

    @Override
    public void messageReceived(String message, Client from, List<Client> recepientList) {
        textArea.append(message + "\n");
    }
}

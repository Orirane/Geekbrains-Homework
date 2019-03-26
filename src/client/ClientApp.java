package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ClientApp extends JFrame {

    private Socket socket;
    private JTextArea outputTextArea;
    private JTextField inputTextField;
    private DataOutputStream outputStream;
    private DataInputStream inputStream;
    private String defaultHost = "localhost";
    private String clientName = "defaultName";

    public ClientApp() {
        initGui();
    }

    private void initReceiver() {
        ChatLogger.backupLogs();
        ChatLogger.clearLogs();
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    String echoMessage = inputStream.readUTF();
                    System.out.println("received message::" + echoMessage);
                    outputTextArea.append(echoMessage);
                    ChatLogger.writeToLogs(echoMessage);

                } catch (IOException e) {
                    try{socket.close();}catch (IOException e1){}
                    reconnect();
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        System.out.println("receiver started");
    }

    private void initConnection() {
        try {
            socket = new Socket(defaultHost, 8080);
            outputStream = new DataOutputStream(socket.getOutputStream());
            inputStream = new DataInputStream(socket.getInputStream());
            System.out.println("connection initialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processMessage() {
        if (!inputTextField.getText().equals("")) {
            String message = inputTextField.getText();
            inputTextField.setText("");
            sendMessage(message);

        }

    }

    private void sendMessage(String message) {
        try {
           String[] msgArray = message.split(" ");
            if(!msgArray[0].equals("/w")){
                System.out.println("sent message::" + message);
                outputStream.writeUTF(message);
            }else{
                System.out.println("sent whisper to "+msgArray[1] +"::" +message);
                outputStream.writeUTF(message+" "+ clientName);
            }
        } catch (IOException e) {
            e.printStackTrace();
    }
    }
    private synchronized void reconnect() {
        outputTextArea.append("Connection to the server is lost\n");
        for (int i = 0; i < 10; i++) {
            outputTextArea.append("Trying to re-establish connection: attempt " + i + "\n");
            try {
                Thread.sleep(2000);
                initConnection();
                if (!socket.isClosed()){
                    sendMessage(clientName);
                    outputTextArea.setText("");
                    return;
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                System.exit(-1);
            }
        }
        System.exit(0);
    }

    private void initGui() {
        outputTextArea = new JTextArea();
        inputTextField = new JTextField();

        setTitle("client.ClientApp");
        setBounds(500, 200, 700, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel textPanel = createTextPanel();
        JPanel buttonPanel = createButtonPanel();
        JPanel authPanel = createAuthPanel(textPanel, buttonPanel);

        add(textPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(authPanel, BorderLayout.NORTH);

        setVisible(true);

        System.out.println("gui initialized ");
    }

    private JPanel createTextPanel() {
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());


        textPanel.add(new JScrollPane(outputTextArea));
        textPanel.setVisible(false);

        outputTextArea.setBackground(new Color(51, 153, 255));
        outputTextArea.setEditable(false);     //non-editable text
        return textPanel;


    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        inputTextField.setBackground(new Color(255, 204, 51));
        inputTextField.addActionListener(e -> processMessage());

        JButton button = new JButton("Send");

        buttonPanel.add(inputTextField);
        buttonPanel.add(button);
        buttonPanel.setVisible(false);
        //button press
        button.addActionListener(e -> {
            processMessage();
        });
        return buttonPanel;
    }

    private JPanel createAuthPanel(JPanel textPanel, JPanel buttonPanel) {
        JPanel authPanel = new JPanel();
        JTextField loginField = new JTextField();
        loginField.addActionListener(e -> processMessage());

        JButton authButton = new JButton("Auth");
        authButton.addActionListener(e -> {
            initConnection();
            initReceiver();
            clientName = loginField.getText();
            sendMessage(loginField.getText());
            authPanel.setVisible(false);
            buttonPanel.setVisible(true);
            textPanel.setVisible(true);
        });


        authPanel.add(loginField);
        authPanel.add(authButton);
        authPanel.setLayout(new BoxLayout(authPanel, BoxLayout.X_AXIS));
        authPanel.setVisible(true);
        return authPanel;
    }

    public static void main(String[] args) {
        new ClientApp();
    }
}

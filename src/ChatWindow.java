import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class ChatWindow extends JFrame implements ActionListener  {
    protected JTextField textField;
    protected JTextArea textArea;
    private final static String newline = "\n";

    public ChatWindow() {
        setLayout(new GridBagLayout());
        setTitle("SCS-Chat 0.0.1");
        setResizable (false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        textField = new JTextField(25);
        textField.addActionListener(this);
        textField.setBackground(Color.GRAY);

        textArea = new JTextArea(25, 25);
        textArea.setEditable(false);
        textArea.setBackground(Color.GRAY);
        textArea.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(this);


        GridBagConstraints c = new GridBagConstraints();

        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 0;
        add(scrollPane, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        add(textField, c);


        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LAST_LINE_END;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 1;

        add(sendButton, c);
        pack();
        setVisible(true);



    }
    public void actionPerformed(ActionEvent evt) {
        String timestamp = LocalTime.now().toString().substring(0, LocalTime.now().toString().indexOf("."));
        String text ="["+timestamp+ "] : " + textField.getText();
        textArea.append(text + newline);
        textField.setText("");
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }



    public static void main(String[] args){
        new ChatWindow();
    }

}
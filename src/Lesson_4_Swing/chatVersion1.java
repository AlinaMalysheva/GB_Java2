package Lesson_4_Swing;

import javax.swing.*;

public class chatVersion1 {
    private JPanel mainPanel;
    private JPanel clientsListPanel;
    private JList clientsList;
    private JTextArea dialogArea;
    private JPanel clientTextPanel;
    private JTextField clientTextField;
    private JButton sendButton;

    public chatVersion1(){
        addListeners();
    }

    private void addListeners(){
        sendButton.addActionListener(e -> chatVersion1.this.sendMessage());
        clientTextField.addActionListener(e -> chatVersion1.this.sendMessage());
    }

    private void sendMessage(){
        String theMessage = clientTextField.getText().trim();
        if (theMessage.isEmpty()){
            return;
        }

        if(clientsList.getSelectedValue() != null) {
            String theSpeaker = clientsList.getSelectedValue().toString();// у Вас почему-то работает без toString. Почему?
            setMessToDialogPanel(theSpeaker, theMessage);
        } else {
                setMessToDialogPanel("Call Center Operator", theMessage);
        }
            clientTextField.setText(null);
    }

    private void setMessToDialogPanel(String _name, String _message){
        String newMessage = String.format("%s: %s%n",_name,_message);
        dialogArea.append(newMessage);
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("the Chatik");
        frame.setContentPane(new chatVersion1().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
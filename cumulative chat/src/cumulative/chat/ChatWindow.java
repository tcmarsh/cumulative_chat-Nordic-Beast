package cumulative.chat;

import java.awt.*;
import javax.swing.*;

public class ChatWindow extends JFrame{
    JPanel displayPanel = new JPanel();
    JPanel inputPanel = new JPanel();
    JTextArea textDisplay = new JTextArea();
    JTextArea textInput = new JTextArea();
    JScrollPane displayScroll = new JScrollPane(textDisplay);
    JScrollPane inputScroll = new JScrollPane(textInput);
    
    
    public ChatWindow(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600,600);
        BoxLayout boxLayout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        this.setLayout(boxLayout);
        
        textDisplay.setEditable(false);
        textDisplay.setText("hi\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nhey");
//        displayScroll.setMaximumSize(new Dimension(500,300));
//        displayScroll.setMinimumSize(new Dimension(500,300));
        
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.PAGE_AXIS));
        displayPanel.setMaximumSize(new Dimension(500,300));
        displayPanel.setMinimumSize(new Dimension(500,300));
        displayPanel.add(displayScroll);
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS));
        inputPanel.setMaximumSize(new Dimension(500,200));
        inputPanel.setMinimumSize(new Dimension(500,200));
        inputPanel.add(inputScroll);
        this.add(displayPanel, BorderLayout.NORTH);
        this.add(inputPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }
}

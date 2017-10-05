package cumulative.chat;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ChatWindow extends JFrame{
    JPanel displayPanel = new JPanel();
    JPanel inputPanel = new JPanel();
    
    JTextArea textDisplay = new JTextArea();
    JTextArea textInput = new JTextArea();
    
    JScrollPane displayScroll = new JScrollPane(textDisplay);
    JScrollPane inputScroll = new JScrollPane(textInput);
    
    JButton send = new JButton("send");
    
    public ChatWindow(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600,600);
        BoxLayout boxLayout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        this.setLayout(boxLayout);
        this.setResizable(false);
        
        textDisplay.setEditable(false);
        
        /*
        * Set max and min sized because otherwise it looked wonky
        */
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.PAGE_AXIS));
        displayPanel.setMaximumSize(new Dimension(500,300));
        displayPanel.setMinimumSize(new Dimension(500,300));
        displayPanel.add(displayScroll);
        displayPanel.setBorder(new EmptyBorder(10,10,40,10));
        
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS));
        inputPanel.setMaximumSize(new Dimension(500,200));
        inputPanel.setMinimumSize(new Dimension(500,200));
        inputPanel.add(inputScroll);
        inputPanel.setBorder(new EmptyBorder(10,10,10,10));
        
        this.add(displayPanel, BorderLayout.NORTH);
        this.add(inputPanel, BorderLayout.CENTER);
        this.add(send, BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    
}

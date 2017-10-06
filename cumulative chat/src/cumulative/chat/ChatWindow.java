package cumulative.chat;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ChatWindow extends JFrame{
    JPanel displayPanel = new JPanel();
    JPanel inputPanel = new JPanel();
    
    JTextArea textDisplay = new JTextArea();
    JTextArea textInput = new JTextArea();
    
    JScrollPane displayScroll = new JScrollPane(textDisplay);
    JScrollPane inputScroll = new JScrollPane(textInput);
    
    JButton sendButton = new JButton("send");
    String inputString = new String();
    
    public ChatWindow(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600,600);
        BoxLayout boxLayout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        this.setLayout(boxLayout);
        this.setResizable(false);
        
        textDisplay.setEditable(false);
        textDisplay.setLineWrap(true);
        textDisplay.setWrapStyleWord(true);
        
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
        
        AbstractAction submit = new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                textInput.selectAll();
                inputString = textInput.getSelectedText();
                textDisplay.append(inputString + "\n\n");
                textInput.setText(null);
            }
        };
        sendButton.addActionListener(submit);
        sendButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,InputEvent.CTRL_MASK),"submitted");
        sendButton.getActionMap().put("submitted",submit);
        
        this.add(displayPanel, BorderLayout.NORTH);
        this.add(inputPanel, BorderLayout.CENTER);
        this.add(sendButton, BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    
}

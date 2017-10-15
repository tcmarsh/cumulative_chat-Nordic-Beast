package cumulative.chat;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ChatWindow extends JFrame{
    
    // Note that the functionality of the program is not impacted by the change I've made
    // Also, I have removed any ambiguity about where these are able to be used by removing them
    
    // Here, I'm using the private modifier to keep anyone trying to modify or (horrors!) replace it
    private JTextArea textDisplay = new JTextArea();
    
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
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.PAGE_AXIS));
        displayPanel.setMaximumSize(new Dimension(500,300));
        displayPanel.setMinimumSize(new Dimension(500,300));

        JScrollPane displayScroll = new JScrollPane(textDisplay);
        displayPanel.add(displayScroll);
        displayPanel.setBorder(new EmptyBorder(10,10,40,10));
        
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS));
        inputPanel.setMaximumSize(new Dimension(500,200));
        inputPanel.setMinimumSize(new Dimension(500,200));

        JTextArea textInput = new JTextArea();
        JScrollPane inputScroll = new JScrollPane(textInput);
        JPanel inputPanel = new JPanel();
        inputPanel.add(inputScroll);
        inputPanel.setBorder(new EmptyBorder(10,10,10,10));
        
        AbstractAction submit = new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                textInput.selectAll();
                String inputString = textInput.getSelectedText();
                textDisplay.append(inputString + "\n\n");
                textInput.setText(null);
            }
        };

        JButton sendButton = new JButton("send");
        sendButton.addActionListener(submit);
        sendButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,InputEvent.CTRL_MASK),"submitted");
        sendButton.getActionMap().put("submitted",submit);
        
        this.add(displayPanel, BorderLayout.NORTH);
        this.add(inputPanel, BorderLayout.CENTER);
        this.add(sendButton, BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    public void appendText(String text) {
        textDisplay.append(text);
    }
}

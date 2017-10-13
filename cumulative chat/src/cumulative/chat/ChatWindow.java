package cumulative.chat;

import java.awt.*;
import java.awt.event.*;
import java.net.Socket;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ChatWindow extends JFrame {

    //Creating everything necessary for the window
    private final JPanel displayPanel = new JPanel();
    private final JPanel inputPanel = new JPanel();

    JTextArea textDisplay = new JTextArea();
    private JTextArea textInput = new JTextArea();

    private final JScrollPane displayScroll = new JScrollPane(textDisplay);
    private final JScrollPane inputScroll = new JScrollPane(textInput);

    private final JButton sendButton = new JButton("send");
    private String inputString = new String();

    public ChatWindow() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 600);
        BoxLayout boxLayout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        this.setLayout(boxLayout);
        this.setResizable(false);
        
        Client client = new Client();

        textDisplay.setEditable(false);
        textDisplay.setLineWrap(true);
        textDisplay.setWrapStyleWord(true);

        /*
        * Set max and min sized because otherwise it looked wonky
         */
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.PAGE_AXIS));
        displayPanel.setMaximumSize(new Dimension(500, 300));
        displayPanel.setMinimumSize(new Dimension(500, 300));
        displayPanel.add(displayScroll);
        displayPanel.setBorder(new EmptyBorder(10, 10, 40, 10));

        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS));
        inputPanel.setMaximumSize(new Dimension(500, 200));
        inputPanel.setMinimumSize(new Dimension(500, 200));
        inputPanel.add(inputScroll);
        inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        AbstractAction submit = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                textInput.selectAll();
                inputString = textInput.getSelectedText();
                client.send(inputString);
                textDisplay.append("\n" + inputString + "\n");
                textInput.setText(null);
            }
        };
        sendButton.addActionListener(submit);
        sendButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, InputEvent.CTRL_MASK), "submitted");
        sendButton.getActionMap().put("submitted", submit);

        this.add(displayPanel, BorderLayout.NORTH);
        this.add(inputPanel, BorderLayout.CENTER);
        this.add(sendButton, BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    public String getIP(){
        String inIP;
        inIP = JOptionPane.showInputDialog(this, "What is the IP of the Server?", null);
        return inIP;
    }

    private static class Handler implements Runnable {
        private final InputStream input;
        public Handler(InputStream inputStream) {
            input = inputStream;
        }
        
        @Override
        public void run(){
            for(int i = 0;i<100;i++){
                try{
                    System.out.println(input.read());
                } catch(IOException e){
                    
                }
            }
        }
    }

    /*
    * From here on, it's client/connection stuff.
     */
    private class Client {
        private PrintWriter stringOutput;
        private Socket socket;
        public Client() {
            
            String IP = getIP();
            try{
                socket = new Socket(IP, 8090);
                stringOutput = new PrintWriter(socket.getOutputStream());
                //new Thread(new Handler(socket.getInputStream())).start();
            } catch (IOException e){
                System.out.println("Starting new Server");
                (new Thread(new ChatServer())).start();
//                try{
//                Thread.sleep(2000);
//                } catch (InterruptedException interrupt){
//                    
//                }
                try{
                    System.out.println("Connecting to Server");
                    socket = new Socket("127.0.0.1", 5222);
                    stringOutput = new PrintWriter(socket.getOutputStream());
                } catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        }

        public void send(String inputString) {
            System.out.println(stringOutput);
            stringOutput.println(inputString);
        }
    }

}

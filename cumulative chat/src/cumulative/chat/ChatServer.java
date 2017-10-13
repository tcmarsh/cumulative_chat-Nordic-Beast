package cumulative.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;


public class ChatServer implements Runnable{
    private ServerSocket ss;
    private BufferedReader br;
    private Reader r;
    private InputStream inStream;
    
    public ChatServer(){
        try{
            ss = new ServerSocket(8090);
            
            while(true){
                Socket socket = ss.accept();
                System.out.println("running");
                
                inStream = socket.getInputStream();
                r = new InputStreamReader(inStream);
                br = new BufferedReader(r);
                while(br.ready()){
                    System.out.println("reading with buffer");
                    System.out.println(br.readLine());
                }
            }
        } catch(IOException e){
            
        }
    }
    
    @Override
    public void run(){
        
    }
}

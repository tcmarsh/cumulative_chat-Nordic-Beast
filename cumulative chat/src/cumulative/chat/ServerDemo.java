package cumulative.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    private ServerSocket ss;
    
    public ServerDemo(){
        try{
            ss = new ServerSocket(5222);
            
            while(true){
                Socket socket = ss.accept();
                
                int read;
                while((read = socket.getInputStream().read()) >= 0){
                    System.out.println(read);
                    socket.getOutputStream().write((read + "\n").getBytes());
                }
            }
        } catch(IOException e) {
            
        }
        
    }
    public static void main(String[] args){
        ServerDemo server = new ServerDemo();
    }
}

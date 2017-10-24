// Extra classes ClientDemo and ServerDemo are left in the code.
package cumulative.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    private ServerSocket ss;
    
    public ServerDemo(){
        try{
            ss = new ServerSocket(5222);
            System.out.println("Socket made");
            
            while(true){
                //accept blocks the program!!! Make a thread or something
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
        // You don't have to assign a variable if it won't be used
        ServerDemo server = new ServerDemo();
    }
}
